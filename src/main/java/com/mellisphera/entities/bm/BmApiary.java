package com.mellisphera.entities.bm;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BmApiary implements Serializable{
	
	
	/*
	 * "uuid": "UjpRybCZ2IXFOf8hx4dJGo9PnH0Qs5Bc",
		"created": "2017-11-18 21:50:39",
		"name": "ZGELOS",
		"postal_code": "64110",
		"country_code": "FR",
		"data_last_received": "2019-04-10 12:45:22",
		"hives": []
	 */
	@JsonProperty("uuid")
	private String uuid;
	@JsonProperty("created")
	private String created;
	@JsonProperty("name")
	private String name;
	@JsonProperty("postal_code")
	private String postalCode;
	@JsonProperty("country_code")
	private String countryCode;
	@JsonProperty("data_last_received")
	private String dataLastReceived;
	@JsonProperty("hives")
	private BmHive[] hives;
	
	public BmApiary() {
		
	}
	public BmApiary(String uuid, String created, String name, String postalCode, String countryCode,
			String dataLastReceived, BmHive[] hives) {
		this.uuid = uuid;
		this.created = created;
		this.name = name;
		this.postalCode = postalCode;
		this.countryCode = countryCode;
		this.dataLastReceived = dataLastReceived;
		this.hives = hives;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDataLastReceived() {
		return dataLastReceived;
	}

	public void setDataLastReceived(String dataLastReceived) {
		this.dataLastReceived = dataLastReceived;
	}

	public BmHive[] getHives() {
		return hives;
	}

	public void setHives(BmHive[] hives) {
		this.hives = hives;
	}
	
	
	
	
	
	
}


/*

{
"code": "200",
"message": "Apiary tree for username 'lorenzo.pons@free.fr'",
"output_format": "json",
"payload_record_count": 7,
"client_ip": "83.173.67.13",
"served_by_node": "bio-web-instance-group-2-8rch",
"payload": [
  {
"uuid": "UjpRybCZ2IXFOf8hx4dJGo9PnH0Qs5Bc",
"created": "2017-11-18 21:50:39",
"name": "ZGELOS",
"postal_code": "64110",
"country_code": "FR",
"data_last_received": "2019-04-10 12:45:22",
"hives": [
  {
"uuid": "bBsXpy30jFq6ghQdr1vI85aP9ilz2tSu",
"created": "2018-10-12 17:31:37",
"name": "R1",
"data_last_received": "2019-04-10 12:35:22",
"devices": [
  {
"uuid": "7nm4q6cUkY9gzoK5L3MatRvAbQJlxyGu",
"created": "2018-10-12 17:31:42",
"device_id": "42:15:0C",
"data_last_received": "2019-04-10 12:25:22",
"is_api_linked": "1",
"name": "42:15:0C"
},
  {
"uuid": "FARGdHeKZfclQmwLOUyzkTDN0XEbvVt8",
"created": "2019-01-24 09:10:37",
"device_id": "43:0A:C7",
"data_last_received": "2019-04-10 12:35:22",
"is_api_linked": "1",
"name": "43:0A:C7"
}
],
},*/