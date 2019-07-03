package com.mellisphera.entities;

import java.util.Date;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CurrentDailyWeather")
public class CurrentDailyWeather {
	
	private String _id;
	private Date date;
	private Map<String, String> weather;
	private Map<String, Float> main;
	private Map<String, Float> wind;
	private Map<String, Float> rain;
	private Map<String, Float> snow;
	private String user;
	private String apiary;
	private String idApiary;
	private String city;
	private String _origin;
	
	
	public CurrentDailyWeather(String _id, Date date, Map<String, String> weather, Map<String, Float> main,
			Map<String, Float> wind, Map<String, Float> rain, Map<String, Float> snow, String user, String apiary,
			String idApiary, String city, String _origin) {
		this._id = _id;
		this.date = date;
		this.weather = weather;
		this.main = main;
		this.wind = wind;
		this.rain = rain;
		this.snow = snow;
		this.user = user;
		this.apiary = apiary;
		this.idApiary = idApiary;
		this.city = city;
		this._origin = _origin;
	}


	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Map<String, String> getWeather() {
		return weather;
	}


	public void setWeather(Map<String, String> weather) {
		this.weather = weather;
	}


	public Map<String, Float> getMain() {
		return main;
	}


	public void setMain(Map<String, Float> main) {
		this.main = main;
	}


	public Map<String, Float> getWind() {
		return wind;
	}


	public void setWind(Map<String, Float> wind) {
		this.wind = wind;
	}


	public Map<String, Float> getRain() {
		return rain;
	}


	public void setRain(Map<String, Float> rain) {
		this.rain = rain;
	}


	public Map<String, Float> getSnow() {
		return snow;
	}


	public void setSnow(Map<String, Float> snow) {
		this.snow = snow;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getApiary() {
		return apiary;
	}


	public void setApiary(String apiary) {
		this.apiary = apiary;
	}


	public String getIdApiary() {
		return idApiary;
	}


	public void setIdApiary(String idApiary) {
		this.idApiary = idApiary;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String get_origin() {
		return _origin;
	}


	public void set_origin(String _origin) {
		this._origin = _origin;
	}
	
	
	
	
	
	
}
