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

import org.json.simple.JSONObject;

public class Location {
	
	private String ip = null;
	private String city = null;
	private String region = null;
	private String country = null;
	private String country_name = null;
	private String postal = null;
	private Double latitude = Double.NaN;
	private Double longitude = Double.NaN;
	private String timezone = null;
	private String languages = null;
	
	
	public Location(String ip, String city, String region, String country, String country_name, String postal, Double latitude, Double longitude, String timezone, String languages) {
		this.ip = ip;
		this.city = city;
		this.region = region;
		this.country = country;
		this.country_name = country_name;
		this.postal = postal;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timezone = timezone;
		this.languages = languages;
	}
	
	public Location(JSONObject json) {
		this.ip = (String)json.get("ip");
		this.city = (String) json.get("city");
		this.region = (String) json.get("region");;
		this.country = (String) json.get("country");
		this.country_name = (String) json.get("country_name");
		this.postal = (String) json.get("postal");
		this.latitude = (Double) json.get("latitude");
		this.longitude = (Double) json.get("longitude");
		this.timezone = (String) json.get("countimezonetry");
		this.languages = (String) json.get("languages");
	}

	public String getIp() {
		return ip;
	}


	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCountry_name() {
		return country_name;
	}


	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}


	public String getPostal() {
		return postal;
	}


	public void setPostal(String postal) {
		this.postal = postal;
	}


	public Double getLatitude() {
		return latitude;
	}


	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}


	public Double getLongitude() {
		return longitude;
	}


	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	public String getTimezone() {
		return timezone;
	}


	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}


	public String getLanguages() {
		return languages;
	}


	public void setLanguages(String languages) {
		this.languages = languages;
	}
	
	@Override
	public String toString() {
		return this.getIp()+" : "+this.getCity()+" : "+this.getLatitude()+" , "+this.getLongitude();
	}
	
	
}
