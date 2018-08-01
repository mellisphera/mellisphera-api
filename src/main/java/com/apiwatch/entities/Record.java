package com.apiwatch.entities;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Record")
public class Record {
	
	public String id;
	public Float battery_ext ;
	public Float battery_int;
	public Float humidity_ext;
	public Float humidity_int;
	public String recordDate;
	public Float weight_icome;
	public String recordsType;
	public String sensorRef;
	public Float temp_ext;
	public Float temp_int;
	public Float weight;
	public String idHive;
	
	
	public Record() {
		super();
	}

	public Record(String id, Float battery_ext, Float battery_int, Float humidity_ext, Float humidity_int,
			String recordDate, Float weight_icome, String recordsType, String sensorRef, Float temp_ext, Float temp_int,
			Float weight, String idHive) {
		super();
		this.id = id;
		this.battery_ext = battery_ext;
		this.battery_int = battery_int;
		this.humidity_ext = humidity_ext;
		this.humidity_int = humidity_int;
		this.recordDate = recordDate;
		this.weight_icome = weight_icome;
		this.recordsType = recordsType;
		this.sensorRef = sensorRef;
		this.temp_ext = temp_ext;
		this.temp_int = temp_int;
		this.weight = weight;
		this.idHive = idHive;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Float getBattery_ext() {
		return battery_ext;
	}


	public void setBattery_ext(Float battery_ext) {
		this.battery_ext = battery_ext;
	}


	public Float getBattery_int() {
		return battery_int;
	}


	public void setBattery_int(Float battery_int) {
		this.battery_int = battery_int;
	}


	public Float getHumidity_ext() {
		return humidity_ext;
	}


	public void setHumidity_ext(Float humidity_ext) {
		this.humidity_ext = humidity_ext;
	}


	public Float getHumidity_int() {
		return humidity_int;
	}


	public void setHumidity_int(Float humidity_int) {
		this.humidity_int = humidity_int;
	}


	public String getRecordDate() {
		return recordDate;
	}


	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}


	public Float getWeight_icome() {
		return weight_icome;
	}


	public void setWeight_icome(Float weight_icome) {
		this.weight_icome = weight_icome;
	}


	public String getRecordsType() {
		return recordsType;
	}


	public void setRecordsType(String recordsType) {
		this.recordsType = recordsType;
	}


	public String getSensorRef() {
		return sensorRef;
	}


	public void setSensorRef(String sensorRef) {
		this.sensorRef = sensorRef;
	}


	public Float getTemp_ext() {
		return temp_ext;
	}


	public void setTemp_ext(Float temp_ext) {
		this.temp_ext = temp_ext;
	}


	public Float getTemp_int() {
		return temp_int;
	}


	public void setTemp_int(Float temp_int) {
		this.temp_int = temp_int;
	}


	public Float getWeight() {
		return weight;
	}


	public void setWeight(Float weight) {
		this.weight = weight;
	}


	public String getIdHive() {
		return idHive;
	}


	public void setIdHive(String idHive) {
		this.idHive = idHive;
	}
	
	


	
	
	
	
}
