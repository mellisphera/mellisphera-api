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

import java.util.Arrays;
import java.util.Date;

public class UserPref {
	
	private String timeZone;
	private String timeFormat;
	private String lang;
	/*private String weatherSource;
	private String[] availableSource;
	private Boolean weatherStation;*/
	private String unitSystem;
	private Date dateRef;
	
	public UserPref(String timeZone, String timeFormat, String lang, String unitSystem) {
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

	public void setDateRef(Date ref){
		this.dateRef = ref;
	}

	public Date getDateRef(){
		return this.dateRef;
	}

	@Override
	public String toString() {
		return "UserPref{" +
				"timeZone='" + timeZone + '\'' +
				", timeFormat='" + timeFormat + '\'' +
				", lang='" + lang + '\'' +
				", unitSystem='" + unitSystem + '\'' +
				", dateRef='" + dateRef + '\'' + 
				'}';
	}
}
