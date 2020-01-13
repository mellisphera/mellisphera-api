/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 



package com.mellisphera.security.service;

import com.mellisphera.controllers.AuthRestApiController;
import com.mellisphera.entities.*;
import com.mellisphera.entities.log.LogEvents;
import com.mellisphera.entities.log.LogType;
import com.mellisphera.execption.ApiaryDemoNotFoundException;
import com.mellisphera.repositories.AlertUserRepository;
import com.mellisphera.repositories.AlertsCatRepository;
import com.mellisphera.repositories.LogRepoitory;
import com.mellisphera.repositories.UserRepository;
import com.mellisphera.security.entities.GeoIp;
import com.mellisphera.security.message.request.SignUpForm;
import com.mellisphera.sharing.SharingService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SignupService {
    public static Log log = LogFactory.getLog(AuthRestApiController.class);

    @Autowired private UserRepository userRepository;
    @Autowired private GeoipServiceImpl geoipService;
    @Autowired private SharingService sharingService;
    @Autowired private LogRepoitory logRepoitory;
    @Autowired private AlertsCatRepository alertsCatRepository;
    @Autowired private AlertUserRepository alertUserRepository;
    @Autowired private PasswordEncoder encoder;
    private static final String DATE_FR = "DD/MM/YYYY HH:mm";
    private static final String DATE_EN = "YYYY-MM-DD HH:m";
    private static final String METRIC = "METRIC";
    private static final String[] AVAILABLE_FREQUENCY = {"EVERY_X_DAY", "DAILY", "WEEKLY"};
    private static final int DAY_FREQUENCY = 1;
    private static final String FREQUENCY = AVAILABLE_FREQUENCY[0];
    private static final String IMPERIAL = "IMPERIAL";
    private static final String[] WEATHER_SOURCE = new String[]{"WeatherSource", "OpenWeatherMap"};
    private static final String[] SET_INITIAL_ROLE = new String[]{ "ROLE_STANDARD" };

    private String userId;
    public SignupService() {
        this.userId = null;
    }

    public User newUser(SignUpForm signUpRequest, Boolean bmSignup) {
        String credential = encoder.encode(signUpRequest.getPassword());
        log.debug(" Sign Up : username :"+ signUpRequest.getUsername() +" password :" + credential);
        User user = new User(this.userId, GregorianCalendar.getInstance().getTime(),signUpRequest.getUsername(), credential,signUpRequest.getEmail(),new HashSet<>(Arrays.asList(SET_INITIAL_ROLE)));
        String ipAddress = ((WebAuthenticationDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getRemoteAddress();
        if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1"))
            ipAddress="87.100.21.93";
        GeoIp geoIp = geoipService.getGeoIp(ipAddress);
        user.setUserPref(new UserPref(geoIp.getTimeZone(), geoIp.getCountry().equals("FR") ? DATE_EN: DATE_FR, this.getLangByGeoipLangage(geoIp.getLanguages()), geoIp.getCountry().equals("FR") ? METRIC: IMPERIAL, WEATHER_SOURCE[0], WEATHER_SOURCE, false));
        user.setLastConnection(new Date());
        User newUser = this.userRepository.insert(user);
        if (!bmSignup) {
            LogEvents logEventsBmAuth = new LogEvents(null, new Date(), newUser.getId(), signUpRequest.getEmail(), LogType.INSCRIPTION, null);
            try{
                this.sharingService.addDemoApiaryNewUser(newUser.getId());
            } catch (ApiaryDemoNotFoundException e) {
                System.err.println(e.getMessage());
            }
            this.logRepoitory.insert(logEventsBmAuth);
        }

        this.setAlertUser(user, geoIp.getCountry().equals("FR") ? METRIC: IMPERIAL);
        return newUser;
    }

    private String getLangByGeoipLangage(String geoLang) {
        if (geoLang.contains("fr")) {
            return "fr";
        } else if (geoLang.contains("es")) {
            return "es";
        } else {
            return "en";
        }
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    private void setAlertUser(User user, String unitType) {
        List<AlertsCat> alertCat = this.alertsCatRepository.findAll();
        Map<String, AlertConf> alertConf = new HashMap<>();
        alertCat.forEach(_alert -> {
            alertConf.put(_alert.get_id(), new AlertConf(true, _alert.getBasicValueMet(), _alert.getBasicValueImp()));
        });
        AlertUser alertUser = new AlertUser(user.getId(), AVAILABLE_FREQUENCY, DAY_FREQUENCY, new String[]{user.getEmail(), ""}, false, FREQUENCY, alertConf);
        this.alertUserRepository.insert(alertUser);
    }
}
