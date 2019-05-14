package com.mellisphera.entities;

public class UserPref {
	
	private String timeZone;
	private String timeFormat;
	private String lang;
	private String unitSystem;
	
	public UserPref(String timeZone, String timeFormat, String lang, String unitSystem) {
		super();
		this.timeZone = timeZone;
		this.timeFormat = timeFormat;
		this.lang = lang;
		this.unitSystem = unitSystem;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getTimeFormat() {
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat) {
		this.timeFormat = timeFormat;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getUnitSystem() {
		return unitSystem;
	}

	public void setUnitSystem(String unitSystem) {
		this.unitSystem = unitSystem;
	}
	
	
	

}
