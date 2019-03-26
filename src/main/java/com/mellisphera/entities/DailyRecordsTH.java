package com.mellisphera.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DailyRecordsTH")
public class DailyRecordsTH {

	private String id;
	private Date recordDate;
	private String idHive;
	private float humidity_int_min;
	private float humidity_int_max;
	private float temp_int_min;
	private float temp_int_max;
	private float temp_int_moy;
	private float temp_int_stddev;
	private String status;
	private String trend;
	private float r_int_text;
        public Long timestamp;
	
	
	public DailyRecordsTH(){
		
	}
	
	public DailyRecordsTH(String id, Date recordDate, String idHive, float humidity_int_min, float humidity_int_max,
			float temp_int_min, float temp_int_max, float temp_int_moy, float temp_int_stddev, String status,
			String trend, float r_int_text, Long timestamp) {
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
		this.status = status;
		this.trend = trend;
		this.r_int_text = r_int_text;
                this.timestamp = timestamp;
	}
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
        public Long getTimestamp(){
            return this.timestamp;
        }
	public Date getRecordDate() {
		return recordDate;
	}
	
        public void setTimestamp(Long newTimestamp){
            this.timestamp = timestamp;
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
		return status;
	}
	
	public void setHealth_status(String status) {
		this.status = status;
	}
	
	public String getHealth_trend() {
		return trend;
	}
	
	public void setHealth_trend(String trend) {
		this.trend = trend;
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
				+ temp_int_stddev + ", status=" + status + ", trend=" + trend
				+ ", r_int_text=" + r_int_text + "]";
	}
	
}
