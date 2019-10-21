/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 



package com.mellisphera.entities;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ForecastDailyWeather")
public class ForecastDailyWeather {

	@Id
	private String _id;
	private Map<String, String> weather;
	private Map<String, String> wind;
	private Map<String, String> main;
	private String _origin;
	private String user;
	private Date date;
	private String city;
	private Map<String, Float> rain;
	private String apiaryId;
	private Map<String, Float> snow;
	private String apiary;
	
	

	public ForecastDailyWeather(String _id, Map<String, String> weather, Map<String, String> wind,
			Map<String, String> main, String _origin, String user, Date date, String city, Map<String, Float> rain,
			String apiaryId, Map<String, Float> snow, String apiary) {
		this._id = _id;
		this.weather = weather;
		this.wind = wind;
		this.main = main;
		this._origin = _origin;
		this.user = user;
		this.date = date;
		this.city = city;
		this.rain = rain;
		this.apiaryId = apiaryId;
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

	public String getapiaryId() {
		return apiaryId;
	}

	public void setapiaryId(String apiaryId) {
		this.apiaryId = apiaryId;
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
