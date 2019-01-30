package com.apiwatch.security.service;

import com.apiwatch.security.entities.GeoIp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

