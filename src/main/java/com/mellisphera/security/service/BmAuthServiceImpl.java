package com.mellisphera.security.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.Hive;
import com.mellisphera.entities.Sensor;
import com.mellisphera.entities.User;
import com.mellisphera.entities.bm.BmApiary;
import com.mellisphera.entities.bm.BmHive;
import com.mellisphera.entities.bm.BmSensor;
import com.mellisphera.repositories.ApiaryRepository;
import com.mellisphera.repositories.HivesRepository;
import com.mellisphera.repositories.SensorRepository;
import com.mellisphera.repositories.UserRepository;
import com.mellisphera.security.entities.BmAuth;

@Service
public class BmAuthServiceImpl implements BmAuthService {
	
    @Value("${apiwatch.app.geoip.timeout}")
    private int timeout;
    @Value("${mellisphera.app.bmAuth.url}")
    private String bmUrl;
    @Value("${mellisphera.app.bmAuth.licenceKey}")
    private String licenceKey;
    
    private HttpEntity<MultiValueMap<String, String>> requestEntity;
    private HttpHeaders header;
    
    @Autowired private ApiaryRepository apiaryRepository;
    @Autowired private HivesRepository hiveRepository;
    @Autowired private SensorRepository sensorRepository;
    @Autowired private UserRepository userRepository;
    
	@Override
	public BmAuth getBmAuth(String username, String password) {
		this.header = new HttpHeaders();
		this.header.add("Content-Type", "application/x-www-form-urlencoded");
		this.header.add("license_key", this.licenceKey);
		MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<String, String>();
		bodyMap.add("username", username);
		bodyMap.add("password", password);
		this.requestEntity = new HttpEntity<>(bodyMap, this.header);
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		BmAuth bmAuth = restTemplate.postForObject(bmUrl, requestEntity, BmAuth.class);
		return bmAuth;
	}

	@Override
	public void saveBmData(BmAuth bmData, User user) {
		for(BmApiary bmApiary: bmData.getPayload()) {
			Apiary newApiary = new Apiary();
			newApiary.setCodePostal(bmApiary.getPostalCode());
			newApiary.setName(bmApiary.getName());
			newApiary.setUser(user);
			newApiary.setUsername(user.getUsername());
			newApiary.setPhoto("./assets/imageClient/testAccount.png");
			String idApiary = this.apiaryRepository.insert(newApiary).getId();
			for(BmHive bmHive: bmApiary.getHives()) {
				Hive newHive = new Hive();
				newHive.setHivePos("0", "0");
				newHive.setIdApiary(idApiary);
				newHive.setUsername(user.getUsername());
				newHive.setName(bmHive.getName());
				newHive.setSensor(bmHive.getDevices().length > 0);
				String idHive = this.hiveRepository.insert(newHive).getId();
				for(BmSensor bmSensor : bmHive.getDevices()) {
					Sensor sensor = new Sensor();
					sensor.setApiaryName(bmApiary.getName());
					sensor.setHiveName(bmHive.getName());
					sensor.setIdApiary(idApiary);
					sensor.setIdHive(idHive);
					sensor.setSensorRef(bmSensor.getDeviceId());
					sensor.setUsername(user.getUsername());
					sensor.setType(this.getTypeByRef(bmSensor.getDeviceId()));
					this.sensorRepository.insert(sensor);
				}
			}
		}
	}
	
	private String getTypeByRef(String ref) {
		String prefix = ref.split(":")[0];
		if (prefix.equals("41")) {
			return "T2";
		} else if (prefix.equals("42")) {
			return "T_HR";
		} else if (prefix.equals("43")) {
			return "WEIGHT";
		} else {
			return "ALIEN";
		}
	}
	
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }
}
