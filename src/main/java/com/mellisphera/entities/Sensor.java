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



package com.mellisphera.entities;

import com.mellisphera.entities.bm.DeviceLocation;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

import org.springframework.data.annotation.Id;

@Document(collection = "Sensor")
public class Sensor {
	@Id
	private String _id;
	private String sensorRef;
	private String model;
	private String name;
	private String type;
	private String hiveId ;
	private String apiaryId;
	private String userId;
	private Date sensorTime;
	private Date createDate;
	private Date dataLastReceived;
	private String username;
	private DeviceLocation deviceLocation;
	private float sensorBat;

	/*  "device": {
            "deviceId": "cOVTBhz1WgDZkp5yNq9ijxCIueRUmswr",
            "deviceAddress": "43:10:7E",
            "name": "43:10:7E",
            "userId": "G8zsCAgnehvF2ajfL3pQ5HXKmZNklEyB",
            "model": "43",
            "dataLastReceived": 1569594993,
            "createDate": 1559668916
        },
        "hivePositionId": "kaWKyaiTccs8R7rffgdR",
        "start": 1520539968
    */
	public Sensor() {
		super();
	}

	public Sensor(String _id, String sensorRef, String model, String name, String type, String hiveId, String apiaryId, String userId, Date sensorTime, Date createDate, Date dataLastReceived, String username, String hivePositionId, Date start, float sensorBat) {
		this._id = _id;
		this.sensorRef = sensorRef;
		this.model = model;
		this.name = name;
		this.type = type;
		this.hiveId = hiveId;
		this.apiaryId = apiaryId;
		this.userId = userId;
		this.sensorTime = sensorTime;
		this.createDate = createDate;
		this.dataLastReceived = dataLastReceived;
		this.username = username;
		this.sensorBat = sensorBat;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getDeviceAddress() {
		return sensorRef;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DeviceLocation getDeviceLocation() {
		return deviceLocation;
	}

	public void setDeviceLocation(DeviceLocation deviceLocation) {
		this.deviceLocation = deviceLocation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHiveId() {
		return hiveId;
	}

	public void setHiveId(String hiveId) {
		this.hiveId = hiveId;
	}

	public String getApiaryId() {
		return apiaryId;
	}

	public void setApiaryId(String apiaryId) {
		this.apiaryId = apiaryId;
	}

	public Date getSensorTime() {
		return sensorTime;
	}

	public void setSensorTime(Date sensorTime) {
		this.sensorTime = sensorTime;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDataLastReceived() {
		return dataLastReceived;
	}

	public void setDataLastReceived(Date dataLastReceived) {
		this.dataLastReceived = dataLastReceived;
	}

	public String getUsername() {
		return username;
	}

	public String getSensorRef() {
		return sensorRef;
	}

	public void setSensorRef(String sensorRef) {
		this.sensorRef = sensorRef;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public float getSensorBat() {
		return sensorBat;
	}

	public void setSensorBat(float sensorBat) {
		this.sensorBat = sensorBat;
	}

	@Override
	public String toString() {
		return "Sensor{" +
				"_id='" + _id + '\'' +
				", sensorRef='" + sensorRef + '\'' +
				", model='" + model + '\'' +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", hiveId='" + hiveId + '\'' +
				", apiaryId='" + apiaryId + '\'' +
				", userId='" + userId + '\'' +
				", sensorTime=" + sensorTime +
				", createDate=" + createDate +
				", dataLastReceived=" + dataLastReceived +
				", username='" + username + '\'' +
				", deviceLocation=" + deviceLocation +
				", sensorBat=" + sensorBat +
				'}';
	}
}
