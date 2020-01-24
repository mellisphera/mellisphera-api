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

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SoldDevices")
public class SoldDevices {

	private String id;
	private String sensorRef;
	private String type;
	private String dateSold;
	private String soldTo;
	//private String soldToEmail;
	
	
	public SoldDevices() {
		super();
	}

	public SoldDevices(String id, String sensorRef, String type, String dateSold, String soldTo) {
		super();
		this.id = id;
		this.sensorRef = sensorRef;
		this.type = type;
		this.dateSold = dateSold;
		this.soldTo = soldTo;
		//this.soldToEmail = soldToEmail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSensorRef() {
		return sensorRef;
	}

	public void setSensorRef(String sensorRef) {
		this.sensorRef = sensorRef;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDateSold() {
		return dateSold;
	}

	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
	}

	public String getSoldTo() {
		return soldTo;
	}

	public void setSoldTo(String soldTo) {
		this.soldTo = soldTo;
	}

	
	
	
	
	
}
