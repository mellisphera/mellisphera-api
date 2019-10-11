package com.mellisphera.entities.bm;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BmSensor implements Serializable{

	@JsonProperty("device")
	private BmDevice device;
	@JsonProperty("hivePositionId")
	private String hivePositionId;
	@JsonProperty("deviceLocationId")
	private String deviceLocationId;
	@JsonProperty("start")
	private long start;

	public BmSensor(BmDevice device, String hivePositionId, long start) {
		this.device = device;
		this.hivePositionId = hivePositionId;
		this.start = start;
	}

	public BmSensor(){}
	public BmDevice getDevice() {
		return device;
	}

	public void setDevice(BmDevice device) {
		this.device = device;
	}

	public String getHivePositionId() {
		return hivePositionId;
	}

	public void setHivePositionId(String hivePositionId) {
		this.hivePositionId = hivePositionId;
	}

	public long getStart() {
		return start;
	}

	public String getDeviceLocationId() {
		return deviceLocationId;
	}

	public void setDeviceLocationId(String deviceLocationId) {
		this.deviceLocationId = deviceLocationId;
	}

	public void setStart(long start) {
		this.start = start;
	}

}
