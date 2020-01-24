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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Record")
public class Record {
	
	private String id;
	private Double battery_ext ;
	private Double battery_int;
	private Double humidity_ext;
	private Double humidity_int;
	private Date recordDate;
	private Double weight_icome;
	private String recordsType;
	private String sensorRef;
	private Double temp_ext;
	private Double temp_int;
	private Double weight;
	private String hiveId;
	private Long timestamp;
	
	
	public Record() {
		super();
	}

	public Record(String id, Double battery_ext, Double battery_int, Double humidity_ext, Double humidity_int,
			Date recordDate, Double weight_icome, String recordsType, String sensorRef, Double temp_ext, Double temp_int,
			Double weight, String hiveId, Long timestamp) {
		super();
		this.id = id;
		this.battery_ext = battery_ext;
		this.battery_int = battery_int;
		this.humidity_ext = humidity_ext;
		this.humidity_int = humidity_int;
		this.recordDate = recordDate;
		this.weight_icome = weight_icome;
		this.recordsType = recordsType;
		this.sensorRef = sensorRef;	
		this.temp_ext = temp_ext;
		this.temp_int = temp_int;
		this.weight = weight;
		this.hiveId = hiveId;
                this.timestamp = timestamp;
	}

	public Record(Date recordDate, Double weight) {
		this.recordDate = recordDate;
		this.weight = weight;
	}
	
	public String getId() {
		return id;
	}

        public Long getTimestamp(){
            return this.timestamp;
        }
        
        public void setTimestamp(Long Timestamp){
            this.timestamp = Timestamp;
        }
        
	public void setId(String id) {
		this.id = id;
	}


	public Double getBattery_ext() {
		return battery_ext;
	}


	public void setBattery_ext(Double battery_ext) {
		this.battery_ext = battery_ext;
	}


	public Double getBattery_int() {
		return battery_int;
	}


	public void setBattery_int(Double battery_int) {
		this.battery_int = battery_int;
	}


	public Double getHumidity_ext() {
		return humidity_ext;
	}


	public void setHumidity_ext(Double humidity_ext) {
		this.humidity_ext = humidity_ext;
	}


	public Double getHumidity_int() {
		return humidity_int;
	}


	public void setHumidity_int(Double humidity_int) {
		this.humidity_int = humidity_int;
	}


	public Date getRecordDate() {
		return recordDate;
	}


	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}


	public Double getWeight_icome() {
		return weight_icome;
	}


	public void setWeight_icome(Double weight_icome) {
		this.weight_icome = weight_icome;
	}


	public String getRecordsType() {
		return recordsType;
	}


	public void setRecordsType(String recordsType) {
		this.recordsType = recordsType;
	}


	public String getSensorRef() {
		return sensorRef;
	}


	public void setSensorRef(String sensorRef) {
		this.sensorRef = sensorRef;
	}


	public Double getTemp_ext() {
		return temp_ext;
	}


	public void setTemp_ext(Double temp_ext) {
		this.temp_ext = temp_ext;
	}


	public Double getTemp_int() {
		return temp_int;
	}


	public void setTemp_int(Double temp_int) {
		this.temp_int = temp_int;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public String gethiveId() {
		return hiveId;
	}


	public void sethiveId(String hiveId) {
		this.hiveId = hiveId;
	}
	
	


	
	
	
	
}
