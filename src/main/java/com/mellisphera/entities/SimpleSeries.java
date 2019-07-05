package com.mellisphera.entities;

import java.util.Date;

public class SimpleSeries {
	private Date date;
	private Float value;
	
	public SimpleSeries(Date date, Float value) {
		this.date = date;
		this.value = value;
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
