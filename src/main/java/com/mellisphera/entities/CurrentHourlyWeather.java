package com.mellisphera.entities;

import java.util.Date;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CurrentHourlyWeather")
public class CurrentHourlyWeather {
	
	private String _id;
	private Date date;
	private Object weather;
	private Object main;
	private Object wind;
	private Object rain;
	private Object snow;
	private String user;
	private String apiary;
	private String idApiary;
	private String city;
	private String _origin;
	
	
	public CurrentHourlyWeather(String _id, Date date, Object weather, Object main,
			Object wind, Object rain, Object snow, String user, String apiary, String idApiary,
			String city, String _origin) {
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


	public Object getWeather() {
		return weather;
	}


	public void setWeather(Object weather) {
		this.weather = weather;
	}


	public Object getMain() {
		return main;
	}


	public void setMain(Object main) {
		this.main = main;
	}


	public Object getWind() {
		return wind;
	}


	public void setWind(Object wind) {
		this.wind = wind;
	}


	public Object getRain() {
		return rain;
	}


	public void setRain(Object rain) {
		this.rain = rain;
	}


	public Object getSnow() {
		return snow;
	}


	public void setSnow(Object snow) {
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
