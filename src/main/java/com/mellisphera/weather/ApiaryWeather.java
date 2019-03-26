package com.mellisphera.weather;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mellisphera.entities.Apiary;

@Document(collection = "ApiaryWeather")
public class ApiaryWeather {

	public String id;
	public Apiary apiary;
	public float temperature;
	public Date date;
	
	public ApiaryWeather() {
		super();
	}

	public ApiaryWeather(String id, Apiary apiary, float temperature, Date date) {
		super();
		this.id = id;
		this.apiary = apiary;
		this.temperature = temperature;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Apiary getApiary() {
		return apiary;
	}

	public void setApiary(Apiary apiary) {
		this.apiary = apiary;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ApiaryWeather [id=" + id + ", apiary=" + apiary + ", temperature=" + temperature + ", date=" + date
				+ "]";
	}
		
}
