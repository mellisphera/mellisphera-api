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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mellisphera.security.entities.GeoIp;

@Service
public class GeoipServiceImpl implements GeopIpService {
    private static final Log log = LogFactory.getLog(GeoipServiceImpl.class);

    @Value("${apiwatch.app.geoip.timeout}")
    private int timeout;

    @Value("${apiwatch.app.geoip.url}")
    private String geoIpUrl;

    @Override
    public GeoIp getGeoIp(String ip) {
        RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
        GeoIp geoIp = restTemplate.getForObject(geoIpUrl + ip + "/json", GeoIp.class);
        if(geoIp != null)
            log.debug(" Geoip :" + geoIp.toString());
        return geoIp;
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }

}

