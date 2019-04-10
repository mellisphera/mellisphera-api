package com.mellisphera.entities.bm;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BmApiary {
	
	
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
	private Date created;
	@JsonProperty("name")
	private String name;
	@JsonProperty("postal_code")
	private String postal_code;
	@JsonProperty("country_code")
	private String countryCode;
	@JsonProperty("data_last_received")
	private Date dataLastReceived;
	@JsonProperty("hvies")
	private BmHive[] hives;
	
	public BmApiary(String uuid, Date created, String name, String postal_code, String countryCode,
			Date dataLastReceived, BmHive[] hives) {
		this.uuid = uuid;
		this.created = created;
		this.name = name;
		this.postal_code = postal_code;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Date getDataLastReceived() {
		return dataLastReceived;
	}

	public void setDataLastReceived(Date dataLastReceived) {
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