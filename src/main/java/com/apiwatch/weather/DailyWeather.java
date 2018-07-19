package com.apiwatch.weather;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DailyWeather")
public class DailyWeather {

	@Id
	public String id;
	public float minTempDay;
	public float maxTempDay;
	public Date day;
	public List<String> icons;
	public String idApiary;
	
	
	public DailyWeather() {
		super();
	}
	public DailyWeather(String id, float minTempDay, float maxTempDay, Date day, List<String> icons, String idApiary) {
		super();
		this.id = id;
		this.minTempDay = minTempDay;
		this.maxTempDay = maxTempDay;
		this.day = day;
		this.icons = icons;
		this.idApiary = idApiary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getMinTempDay() {
		return minTempDay;
	}
	public void setMinTempDay(float minTempDay) {
		this.minTempDay = minTempDay;
	}
	public float getMaxTempDay() {
		return maxTempDay;
	}
	public void setMaxTempDay(float maxTempDay) {
		this.maxTempDay = maxTempDay;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public List<String> getIcons() {
		return icons;
	}
	public void setIcons(List<String> icons) {
		this.icons = icons;
	}
	public String getIdApiary() {
		return idApiary;
	}
	public void setIdApiary(String idApiary) {
		this.idApiary = idApiary;
	}
	
	
	


	
}
