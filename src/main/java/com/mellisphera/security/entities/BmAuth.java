package com.mellisphera.security.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mellisphera.entities.bm.BmApiary;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BmAuth implements Serializable {

	/**
	 * 
	 */
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
	@JsonProperty("output_format")
	private String outputFormat;
	@JsonProperty("client_ip")
	private String clientIp;
	@JsonProperty("served_by_node")
	private String servedByNode;
	@JsonProperty("payload")
	private BmApiary[] payload;
	
	public BmAuth() {
		
	}
	
	public BmAuth(String code, String message, String outputFormat, String clientIp, String servedByNode,
			BmApiary[] payload) {
		this.code = code;
		this.message = message;
		this.outputFormat = outputFormat;
		this.clientIp = clientIp;
		this.servedByNode = servedByNode;
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

	public String getOutputFormat() {
		return outputFormat;
	}

	public void setOutputFormat(String outputFormat) {
		this.outputFormat = outputFormat;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getServedByNode() {
		return servedByNode;
	}

	public void setServedByNode(String servedByNode) {
		this.servedByNode = servedByNode;
	}

	public BmApiary[] getPayload() {
		return payload;
	}

	public void setPayload(BmApiary[] payload) {
		this.payload = payload;
	}
	@Override
	public String toString() {
		return "Bm {" + this.getCode() + " - " + this.getMessage() + " - " + this.getClientIp() + " - "+ " - " + this.getPayload() + "}"; 
	}
	
	
	
	
	
}
