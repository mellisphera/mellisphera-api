package com.mellisphera.entities;

import java.util.Date;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ForecastDailyWeather")
public class ForecastDailyWeather {

	private String _id;
	private Map<String, String> weather;
	private Map<String, String> wind;
	private Map<String, String> main;
	private String _origin;
	private String user;
	private Date date;
	private String city;
	private Map<String, Float> rain;
	private String idApiary;
	private Map<String, Float> snow;
	private String apiary;
	
	

	public ForecastDailyWeather(String _id, Map<String, String> weather, Map<String, String> wind,
			Map<String, String> main, String _origin, String user, Date date, String city, Map<String, Float> rain,
			String idApiary, Map<String, Float> snow, String apiary) {
		this._id = _id;
		this.weather = weather;
		this.wind = wind;
		this.main = main;
		this._origin = _origin;
		this.user = user;
		this.date = date;
		this.city = city;
		this.rain = rain;
		this.idApiary = idApiary;
		this.snow = snow;
		this.apiary = apiary;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Map<String, String> getWeather() {
		return weather;
	}

	public void setWeather(Map<String, String> weather) {
		this.weather = weather;
	}

	public Map<String, String> getWind() {
		return wind;
	}

	public void setWind(Map<String, String> wind) {
		this.wind = wind;
	}

	public Map<String, String> getMain() {
		return main;
	}

	public void setMain(Map<String, String> main) {
		this.main = main;
	}

	public String get_origin() {
		return _origin;
	}

	public void set_origin(String _origin) {
		this._origin = _origin;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Map<String, Float> getRain() {
		return rain;
	}

	public void setRain(Map<String, Float> rain) {
		this.rain = rain;
	}

	public String getIdApiary() {
		return idApiary;
	}

	public void setIdApiary(String idApiary) {
		this.idApiary = idApiary;
	}

	public Map<String, Float> getSnow() {
		return snow;
	}

	public void setSnow(Map<String, Float> show) {
		this.snow = snow;
	}

	public String getApiary() {
		return apiary;
	}

	public void setApiary(String apiary) {
		this.apiary = apiary;
	}
	
	

}
