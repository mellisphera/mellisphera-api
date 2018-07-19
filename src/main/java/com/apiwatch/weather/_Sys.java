package com.apiwatch.weather;

public class _Sys {

	public int type;
	public long id;
	public float message;
	public String country ;
	public long sunrise ; 
	public long sunset;
	
	public _Sys() {
		super();
	}
	public _Sys(int type, long id, float message, String country, long sunrise, long sunset) {
		super();
		this.type = type;
		this.id = id;
		this.message = message;
		this.country = country;
		this.sunrise = sunrise;
		this.sunset = sunset;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getMessage() {
		return message;
	}
	public void setMessage(float message) {
		this.message = message;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getSunrise() {
		return sunrise;
	}
	public void setSunrise(long sunrise) {
		this.sunrise = sunrise;
	}
	public long getSunset() {
		return sunset;
	}
	public void setSunset(long sunset) {
		this.sunset = sunset;
	}
	
	
}
