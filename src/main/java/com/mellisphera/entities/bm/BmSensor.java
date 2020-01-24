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

	@Override
	public String toString() {
		return "BmSensor{" +
				"device=" + device +
				", hivePositionId='" + hivePositionId + '\'' +
				", deviceLocationId='" + deviceLocationId + '\'' +
				", start=" + start +
				'}';
	}
}
