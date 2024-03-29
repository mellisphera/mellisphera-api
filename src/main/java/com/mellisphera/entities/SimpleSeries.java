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

public class SimpleSeries {
	private Date date;
	private Object value;
	private String sensorRef;
	private String position;

	public SimpleSeries(Date date, Object value, String sensorRef){
		this.date = date;
		this.value = value;
		this.sensorRef = sensorRef;
	}
	
	public SimpleSeries(Date date, Object value, String sensorRef, String position) {
		this.date = date;
		this.value = value;
		this.sensorRef = sensorRef;
		this.position = position;
	}
	
	
	public String getSensorRef() {
		return sensorRef;
	}


	public void setSensorRef(String sensorRef) {
		this.sensorRef = sensorRef;
	}


	public SimpleSeries(Date date, int value) {
		this.date = date;
		this.value = (float)value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
	
	public String getPosition(){
		return this.position;
	}

	public void setPosition(String pos){
		this.position = pos;
	}
}
