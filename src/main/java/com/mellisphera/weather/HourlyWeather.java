package com.mellisphera.weather;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "HourlyWeather")
public class HourlyWeather {
	
	@Id
	public String id;
	public WeatherAPI weather;
	public Date recordDate; 
	public String idApiary;
	
	public HourlyWeather(String id, WeatherAPI weather, Date recordDate, String idApiary) {
		super();
		this.id = id;
		this.weather = weather;
		this.recordDate = recordDate;
		this.idApiary = idApiary;
	}
	public HourlyWeather() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public WeatherAPI getWeather() {
		return weather;
	}
	public void setWeather(WeatherAPI weather) {
		this.weather = weather;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getIdApiary() {
		return idApiary;
	}
	public void setIdApiary(String idApiary) {
		this.idApiary = idApiary;
	}
	

	
	
	
	
	
	
	
}
