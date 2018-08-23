package com.apiwatch.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DailyRecordsTH")
public class DailyRecordsTH {

	public String id;
	public Date recordDate;
	public String idHive;
	public float humidity_int_min;
	public float humidity_int_max;
	public float temp_int_min;
	public float temp_int_max;
	public float temp_int_moy;
	public float temp_int_stddev;
	public String health_status;
	public String health_trend;
	public float r_int_text;
	
	
	public DailyRecordsTH(){
		
	}
	
	public DailyRecordsTH(String id, Date recordDate, String idHive, float humidity_int_min, float humidity_int_max,
			float temp_int_min, float temp_int_max, float temp_int_moy, float temp_int_stddev, String health_status,
			String health_trend, float r_int_text) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.idHive = idHive;
		this.humidity_int_min = humidity_int_min;
		this.humidity_int_max = humidity_int_max;
		this.temp_int_min = temp_int_min;
		this.temp_int_max = temp_int_max;
		this.temp_int_moy = temp_int_moy;
		this.temp_int_stddev = temp_int_stddev;
		this.health_status = health_status;
		this.health_trend = health_trend;
		this.r_int_text = r_int_text;
	}
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getRecordDate() {
		return recordDate;
	}
	
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	
	public String getIdHive() {
		return idHive;
	}
	
	public void setIdHive(String idHive) {
		this.idHive = idHive;
	}
	
	public float getHumidity_int_min() {
		return humidity_int_min;
	}
	
	public void setHumidity_int_min(float humidity_int_min) {
		this.humidity_int_min = humidity_int_min;
	}
	
	public float getHumidity_int_max() {
		return humidity_int_max;
	}
	
	public void setHumidity_int_max(float humidity_int_max) {
		this.humidity_int_max = humidity_int_max;
	}
	
	public float getTemp_int_min() {
		return temp_int_min;
	}
	
	public void setTemp_int_min(float temp_int_min) {
		this.temp_int_min = temp_int_min;
	}
	
	public float getTemp_int_max() {
		return temp_int_max;
	}
	
	public void setTemp_int_max(float temp_int_max) {
		this.temp_int_max = temp_int_max;
	}
	
	public float getTemp_int_moy() {
		return temp_int_moy;
	}
	
	public void setTemp_int_moy(float temp_int_moy) {
		this.temp_int_moy = temp_int_moy;
	}
	
	public float getTemp_int_stddev() {
		return temp_int_stddev;
	}
	
	public void setTemp_int_stddev(float temp_int_stddev) {
		this.temp_int_stddev = temp_int_stddev;
	}
	
	public String getHealth_status() {
		return health_status;
	}
	
	public void setHealth_status(String health_status) {
		this.health_status = health_status;
	}
	
	public String getHealth_trend() {
		return health_trend;
	}
	
	public void setHealth_trend(String health_trend) {
		this.health_trend = health_trend;
	}
	
	public float getR_int_text() {
		return r_int_text;
	}
	
	public void setR_int_text(float r_int_text) {
		this.r_int_text = r_int_text;
	}
	
	@Override
	public String toString() {
		return "DailyRecordsTH [id=" + id + ", recordDate=" + recordDate + ", idHive=" + idHive + ", humidity_int_min="
				+ humidity_int_min + ", humidity_int_max=" + humidity_int_max + ", temp_int_min=" + temp_int_min
				+ ", temp_int_max=" + temp_int_max + ", temp_int_moy=" + temp_int_moy + ", temp_int_stddev="
				+ temp_int_stddev + ", health_status=" + health_status + ", health_trend=" + health_trend
				+ ", r_int_text=" + r_int_text + "]";
	}
	
}
