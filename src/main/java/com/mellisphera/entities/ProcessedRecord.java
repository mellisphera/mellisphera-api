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

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProcessedDailyRecord")
public class ProcessedRecord {

	public String id;
	public String recordDate;
	public String idHive;
	public Float humidity_ext_min;
	public Float humidity_ext_max;
	public Float humidity_int_min;
	public Float humidity_int_max; 
	public Float temp_ext_min;
	public Float temp_ext_max;
	public Float temp_int_min;
	public Float temp_int_max;
	public Float temp_int_moy;
	public Float temp_ext_moy;
	public Float temp_int_stddev;
	public Float r_tint_text;
	public String health_status;
	public String health_trend;
	public Float weight_min;
	public Float weight_max;
	public Float weight_gain;
	public Float weight_income_gain;
	public Float weight_foragingbees;
	/*
	public Float weight_hive;
	public Float weight_colony;
	public Float weight_filling_rate;
	*/
	
	
	
	public ProcessedRecord() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}
	public String getIdHive() {
		return idHive;
	}
	public void setIdHive(String idHive) {
		this.idHive = idHive;
	}
	public Float getHumidity_ext_min() {
		return humidity_ext_min;
	}
	public void setHumidity_ext_min(Float humidity_ext_min) {
		this.humidity_ext_min = humidity_ext_min;
	}
	public Float getHumidity_ext_max() {
		return humidity_ext_max;
	}
	public void setHumidity_ext_max(Float humidity_ext_max) {
		this.humidity_ext_max = humidity_ext_max;
	}
	public Float getHumidity_int_min() {
		return humidity_int_min;
	}
	public void setHumidity_int_min(Float humidity_int_min) {
		this.humidity_int_min = humidity_int_min;
	}
	public Float getHumidity_int_max() {
		return humidity_int_max;
	}
	public void setHumidity_int_max(Float humidity_int_max) {
		this.humidity_int_max = humidity_int_max;
	}
	public Float getTemp_ext_min() {
		return temp_ext_min;
	}
	public void setTemp_ext_min(Float temp_ext_min) {
		this.temp_ext_min = temp_ext_min;
	}
	public Float getTemp_ext_max() {
		return temp_ext_max;
	}
	public void setTemp_ext_max(Float temp_ext_max) {
		this.temp_ext_max = temp_ext_max;
	}
	public Float getTemp_int_min() {
		return temp_int_min;
	}
	public void setTemp_int_min(Float temp_int_min) {
		this.temp_int_min = temp_int_min;
	}
	public Float getTemp_int_max() {
		return temp_int_max;
	}
	public void setTemp_int_max(Float temp_int_max) {
		this.temp_int_max = temp_int_max;
	}
	public Float getTemp_int_moy() {
		return temp_int_moy;
	}
	public void setTemp_int_moy(Float temp_int_moy) {
		this.temp_int_moy = temp_int_moy;
	}
	public Float getTemp_ext_moy() {
		return temp_ext_moy;
	}
	public void setTemp_ext_moy(Float temp_ext_moy) {
		this.temp_ext_moy = temp_ext_moy;
	}
	public Float getTemp_int_stddev() {
		return temp_int_stddev;
	}
	public void setTemp_int_stddev(Float temp_int_stddev) {
		this.temp_int_stddev = temp_int_stddev;
	}
	public Float getR_tint_text() {
		return r_tint_text;
	}
	public void setR_tint_text(Float r_tint_text) {
		this.r_tint_text = r_tint_text;
	}
	public String getHealth_status() {
		return health_status;
	}
	public void setHealth_status(String health_status) {
		this.health_status = health_status;
	}
	public String getHealth_trend() {
		return health_trend;
	}
	public void setHealth_trend(String health_trend) {
		this.health_trend = health_trend;
	}
	public Float getWeight_min() {
		return weight_min;
	}
	public void setWeight_min(Float weight_min) {
		this.weight_min = weight_min;
	}
	public Float getWeight_max() {
		return weight_max;
	}
	public void setWeight_max(Float weight_max) {
		this.weight_max = weight_max;
	}
	public Float getWeight_gain() {
		return weight_gain;
	}
	public void setWeight_gain(Float weight_gain) {
		this.weight_gain = weight_gain;
	}
	public Float getWeight_income_gain() {
		return weight_income_gain;
	}
	public void setWeight_income_gain(Float weight_income_gain) {
		this.weight_income_gain = weight_income_gain;
	}
	public Float getWeight_foragingbees() {
		return weight_foragingbees;
	}
	public void setWeight_foragingbees(Float weight_foragingbees) {
		this.weight_foragingbees = weight_foragingbees;
	}
	
	
	
	
	
}
