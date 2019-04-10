package com.mellisphera.security.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.mellisphera.security.entities.BmAuth;

@Service
public class BmAuthServiceImpl implements BmAuthService {
    private static final Log log = LogFactory.getLog(BmAuthServiceImpl.class);

	
    @Value("${apiwatch.app.geoip.timeout}")
    private int timeout;
    @Value("$(mellisphera.app.bmAuth.url}")
    private String bmUrl;
    @Value("$(mellisphera.app.bmAuth.licenceKey}")
    private String licenceKey;
    
    private HttpEntity<MultiValueMap<String, String>> requestEntity;
    private HttpHeaders header;
    
    
	@Override
	public BmAuth getBmAuth(String username, String password) {
		this.header.add("Content-Type", "application/x-www-form-urlencoded");
		this.header.add("license_key", this.licenceKey);
		
		MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<String, String>();
		this.requestEntity = new HttpEntity<>(bodyMap, this.header);
		RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
		BmAuth bmAuth = restTemplate.postForObject(bmUrl, requestEntity, BmAuth.class);
		return bmAuth;
	}

	
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }
}
