package com.mellisphera.entities;

import java.util.Date;

public class SimpleSeries {
	private Date date;
	private Float value;
	private String sensorRef;
	
	public SimpleSeries(Date date, Float value, String sensorRef) {
		this.date = date;
		this.value = value;
		this.sensorRef = sensorRef;
	}
	
	
	public String getSensorRef() {
		return sensorRef;
	}


	public void setSensorRef(String sensorRef) {
		this.sensorRef = sensorRef;
	}


	public SimpleSeries(Date date, int value) {
		this.date = date;
		this.value = (float)value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
	
	
}
