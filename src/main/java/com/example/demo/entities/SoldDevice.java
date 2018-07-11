package com.example.demo.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SoldDevices")
public class SoldDevice {

	public String id;
	public String sensorRef;
	public String type;
	public Date dateSold;
	public String soldTo;
	public String soldToEmail;
	
	
	public SoldDevice() {
		super();
	}

	public SoldDevice(String id, String sensorRef, String type, Date dateSold, String soldTo, String soldToEmail) {
		super();
		this.id = id;
		this.sensorRef = sensorRef;
		this.type = type;
		this.dateSold = dateSold;
		this.soldTo = soldTo;
		this.soldToEmail = soldToEmail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSensorRef() {
		return sensorRef;
	}

	public void setSensorRef(String sensorRef) {
		this.sensorRef = sensorRef;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateSold() {
		return dateSold;
	}

	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}

	public String getSoldTo() {
		return soldTo;
	}

	public void setSoldTo(String soldTo) {
		this.soldTo = soldTo;
	}

	public String getSoldToEmail() {
		return soldToEmail;
	}

	public void setSoldToEmail(String soldToEmail) {
		this.soldToEmail = soldToEmail;
	}
	
	
	
	
	
}
