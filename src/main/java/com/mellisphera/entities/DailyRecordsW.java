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

@Document(collection = "DailyRecordsW")
public class DailyRecordsW {

	private String id;
	private Date recordDate;
	private String hiveId;
	private float temp_ext_min;
	private float temp_ext_max;
	private float weight_min;
	private float weight_max;
	private float weight_gain;
	private float weight_income_gain;
	private float weight_foragingbees;
	private float weight_hive;
	private float weight_colony;
	private float weight_filling_rate;
	private Long timestamp;
    private String sensorRef;
	
	public DailyRecordsW(){
		
	}
	
	public DailyRecordsW(String id, Date recordDate, String hiveId, float temp_ext_min, float temp_ext_max,
			float weight_min, float weight_max, float weight_gain, float weight_income_gain, float weight_foragingbees,
			float weight_hive, float weight_colony, float weight_filling_rate, Long timestamp, String sensorRef) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.hiveId = hiveId;
		this.temp_ext_min = temp_ext_min;
		this.temp_ext_max = temp_ext_max;
		this.weight_min = weight_min;
		this.weight_max = weight_max;
		this.weight_gain = weight_gain;
		this.weight_income_gain = weight_income_gain;
		this.weight_foragingbees = weight_foragingbees;
		this.weight_hive = weight_hive;
		this.weight_colony = weight_colony;
		this.weight_filling_rate = weight_filling_rate;
        this.timestamp = timestamp;
        this.sensorRef = sensorRef;
	}

	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public float getTemp_ext_min() {
		return temp_ext_min;
	}

	public void setTemp_ext_min(float temp_ext_min) {
		this.temp_ext_min = temp_ext_min;
	}

	public float getTemp_ext_max() {
		return temp_ext_max;
	}

	public void setTemp_ext_max(float temp_ext_max) {
		this.temp_ext_max = temp_ext_max;
	}

	public String getSensorRef() {
		return sensorRef;
	}

	public void setSensorRef(String sensorRef) {
		this.sensorRef = sensorRef;
	}

	public Date getRecordDate() {
		return recordDate;
	}
	
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	
	public String gethiveId() {
		return hiveId;
	}
	
	public void sethiveId(String hiveId) {
		this.hiveId = hiveId;
	}
	
	
	public float getTemp_int_min() {
		return temp_ext_min;
	}
	
	public void setTemp_int_min(float temp_ext_min) {
		this.temp_ext_min = temp_ext_min;
	}
	
	public float getTemp_int_max() {
		return temp_ext_max;
	}
	
	public void setTemp_int_max(float temp_ext_max) {
		this.temp_ext_max = temp_ext_max;
	}

        public Long getTimestamp(){
            return this.timestamp;
        }

	public float getWeight_min() {
		return weight_min;
	}



	public void setWeight_min(float weight_min) {
		this.weight_min = weight_min;
	}



	public float getWeight_max() {
		return weight_max;
	}



	public void setWeight_max(float weight_max) {
		this.weight_max = weight_max;
	}



	public float getWeight_gain() {
		return weight_gain;
	}



	public void setWeight_gain(float weight_gain) {
		this.weight_gain = weight_gain;
	}



	public float getWeight_income_gain() {
		return weight_income_gain;
	}



	public void setWeight_income_gain(float weight_income_gain) {
		this.weight_income_gain = weight_income_gain;
	}



	public float getWeight_foragingbees() {
		return weight_foragingbees;
	}



	public void setWeight_foragingbees(float weight_foragingbees) {
		this.weight_foragingbees = weight_foragingbees;
	}



	public float getWeight_hive() {
		return weight_hive;
	}



	public void setWeight_hive(float weight_hive) {
		this.weight_hive = weight_hive;
	}



	public float getWeight_colony() {
		return weight_colony;
	}



	public void setWeight_colony(float weight_colony) {
		this.weight_colony = weight_colony;
	}



	public float getWeight_filling_rate() {
		return weight_filling_rate;
	}



	public void setWeight_filling_rate(float weight_filling_rate) {
		this.weight_filling_rate = weight_filling_rate;
	}
        
        public void setTimestamp(Long newTimestamp){
            this.timestamp = timestamp;
        }


	@Override
	public String toString() {
		return "DailyRecordsW [id=" + id + ", recordDate=" + recordDate + ", hiveId=" + hiveId + ", temp_ext_min="
				+ temp_ext_min + ", temp_ext_max=" + temp_ext_max + ", weight_min=" + weight_min + ", weight_max="
				+ weight_max + ", weight_gain=" + weight_gain + ", weight_income_gain=" + weight_income_gain
				+ ", weight_foragingbees=" + weight_foragingbees + ", weight_hive=" + weight_hive + ", weight_colony="
				+ weight_colony + ", weight_filling_rate=" + weight_filling_rate + "]";
	}
	
	
}
