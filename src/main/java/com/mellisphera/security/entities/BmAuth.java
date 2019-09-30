package com.mellisphera.security.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mellisphera.entities.bm.BmApiary;
import com.mellisphera.entities.bm.BmData;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BmAuth implements Serializable {


	/*
			 * {
		"code": "200",
		"message": "Apiary tree for username 'lorenzo.pons@free.fr'",
		"output_format": "json",
		"payload_record_count": 7,
		"client_ip": "83.173.67.13",
		"served_by_node": "bio-web-instance-group-2-8rch",
		"payload": [
		  {
	 */
	@JsonProperty("code")
	private String code;
	@JsonProperty("message")
	private String message;
	@JsonProperty("payload")
	private BmData payload;
	
	public BmAuth() {
		
	}
	
	public BmAuth(String code, String message, String outputFormat, String clientIp, String servedByNode,
                  BmData payload) {
		this.code = code;
		this.message = message;
		this.payload = payload;
	}


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BmData getPayload() {
        return payload;
    }

    public void setPayload(BmData payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "BmAuth{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", payload=" + payload +
                '}';
    }
}
