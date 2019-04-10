package com.mellisphera.entities.bm;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BmSensor {
	
	/*
	 * "uuid": "7nm4q6cUkY9gzoK5L3MatRvAbQJlxyGu",
	"created": "2018-10-12 17:31:42",
	"device_id": "42:15:0C",
	"data_last_received": "2019-04-10 12:25:22",
	"is_api_linked": "1",
	"name": "42:15:0C"

	 */
	@JsonProperty("uuid")
	private String uuid;
	@JsonProperty("created")
	private Date created;
	@JsonProperty("data_last_received")
	private String deviceId;
	@JsonProperty("data_last_received")
	private Date dataLastReceived;
	@JsonProperty("name")
	private String name;
	private int isApiLinked;
	
	public BmSensor(String uuid, Date created, String deviceId, Date dataLastReceived, int isApiLinked, String name) {
		this.uuid = uuid;
		this.created = created;
		this.deviceId = deviceId;
		this.name = name;
		this.dataLastReceived = dataLastReceived;
		this.isApiLinked = isApiLinked;
	}

	public String getUuid() {
		return uuid;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Date getDataLastReceived() {
		return dataLastReceived;
	}

	public void setDataLastReceived(Date dataLastReceived) {
		this.dataLastReceived = dataLastReceived;
	}

	public int getisApiLinked() {
		return isApiLinked;
	}

	public void setIsApiLinked(int isApiLinked) {
		this.isApiLinked = isApiLinked;
	}
	
	
	
}
