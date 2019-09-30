package com.mellisphera.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
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
	private String hiveName;
	private Date sensorTime;
	private Timestamp createDate;
	private Timestamp dataLastReceived;
	private String username;
	private String hivePositionId;
	private Timestamp start;
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

	public Sensor(String _id, String sensorRef, String model, String name, String type, String hiveId, String apiaryId, String hiveName, Date sensorTime, Timestamp createDate, Timestamp dataLastReceived, String username, String hivePositionId, Timestamp start, float sensorBat) {
		this._id = _id;
		this.sensorRef = sensorRef;
		this.model = model;
		this.name = name;
		this.type = type;
		this.hiveId = hiveId;
		this.apiaryId = apiaryId;
		this.hiveName = hiveName;
		this.sensorTime = sensorTime;
		this.createDate = createDate;
		this.dataLastReceived = dataLastReceived;
		this.username = username;
		this.hivePositionId = hivePositionId;
		this.start = start;
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

	public String getHiveName() {
		return hiveName;
	}

	public void setHiveName(String hiveName) {
		this.hiveName = hiveName;
	}

	public Date getSensorTime() {
		return sensorTime;
	}

	public void setSensorTime(Date sensorTime) {
		this.sensorTime = sensorTime;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getDataLastReceived() {
		return dataLastReceived;
	}

	public void setDataLastReceived(Timestamp dataLastReceived) {
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

	public String getHivePositionId() {
		return hivePositionId;
	}

	public void setHivePositionId(String hivePositionId) {
		this.hivePositionId = hivePositionId;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public float getSensorBat() {
		return sensorBat;
	}

	public void setSensorBat(float sensorBat) {
		this.sensorBat = sensorBat;
	}
}
