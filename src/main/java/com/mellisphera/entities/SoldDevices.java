package com.mellisphera.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SoldDevices")
public class SoldDevices {

	private String id;
	private String sensorRef;
	private String type;
	private String dateSold;
	private String soldTo;
	//private String soldToEmail;
	
	
	public SoldDevices() {
		super();
	}

	public SoldDevices(String id, String sensorRef, String type, String dateSold, String soldTo) {
		super();
		this.id = id;
		this.sensorRef = sensorRef;
		this.type = type;
		this.dateSold = dateSold;
		this.soldTo = soldTo;
		//this.soldToEmail = soldToEmail;
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

	public String getDateSold() {
		return dateSold;
	}

	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
	}

	public String getSoldTo() {
		return soldTo;
	}

	public void setSoldTo(String soldTo) {
		this.soldTo = soldTo;
	}

	
	
	
	
	
}
