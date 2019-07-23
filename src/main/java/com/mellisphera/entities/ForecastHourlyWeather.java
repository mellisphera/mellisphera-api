package com.mellisphera.entities;

import java.util.Date;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ForecastHourlyWeather")
public class ForecastHourlyWeather {
	
	private String _id;
	private String rain;
	private Date date;
	private String user;
	private Float swon;
	private Map<String, String> weather;
	private String city;
	private Map<String, Float> main;
	private String apiary;
	private String idApiary;
	private String _origin;
	private Map<String, Float> wind;
	
	
	
	public ForecastHourlyWeather(String _id, String rain, Date date, String user, Float swon,
			Map<String, String> weather, String city, Map<String, Float> main, String apiary, String _origin,
			Map<String, Float> wind, String idApiary) {
		this._id = _id;
		this.rain = rain;
		this.date = date;
		this.user = user;
		this.swon = swon;
		this.weather = weather;
		this.city = city;
		this.main = main;
		this.apiary = apiary;
		this._origin = _origin;
		this.wind = wind;
		this.idApiary = idApiary;
	}
	public String get_id() {
		return _id;
	}
	
	
	public String getIdApiary() {
		return idApiary;
	}
	public void setIdApiary(String idApiary) {
		this.idApiary = idApiary;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getRain() {
		return rain;
	}
	public void setRain(String rain) {
		this.rain = rain;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Float getSwon() {
		return swon;
	}
	public void setSwon(Float swon) {
		this.swon = swon;
	}
	public Map<String, String> getWeather() {
		return weather;
	}
	public void setWeather(Map<String, String> weather) {
		this.weather = weather;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Map<String, Float> getMain() {
		return main;
	}
	public void setMain(Map<String, Float> main) {
		this.main = main;
	}
	public String getApiary() {
		return apiary;
	}
	public void setApiary(String apiary) {
		this.apiary = apiary;
	}
	public String get_origin() {
		return _origin;
	}
	public void set_origin(String _origin) {
		this._origin = _origin;
	}
	public Map<String, Float> getWind() {
		return wind;
	}
	public void setWind(Map<String, Float>  wind) {
		this.wind = wind;
	}
	
	
	
}
