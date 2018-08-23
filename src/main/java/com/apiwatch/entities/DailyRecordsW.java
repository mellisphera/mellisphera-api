package com.apiwatch.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DailyRecordsW")
public class DailyRecordsW {

	public String id;
	public Date recordDate;
	public String idHive;
	public float temp_int_min;
	public float temp_int_max;
	public float weight_min;
	public float weight_max;
	public float weight_gain;
	public float weight_income_gain;
	public float weight_foragingbees;
	public float weight_hive;
	public float weight_colony;
	public float weight_filling_rate;
	
	public DailyRecordsW(){
		
	}
	
	public DailyRecordsW(String id, Date recordDate, String idHive, float temp_int_min, float temp_int_max,
			float weight_min, float weight_max, float weight_gain, float weight_income_gain, float weight_foragingbees,
			float weight_hive, float weight_colony, float weight_filling_rate) {
		super();
		this.id = id;
		this.recordDate = recordDate;
		this.idHive = idHive;
		this.temp_int_min = temp_int_min;
		this.temp_int_max = temp_int_max;
		this.weight_min = weight_min;
		this.weight_max = weight_max;
		this.weight_gain = weight_gain;
		this.weight_income_gain = weight_income_gain;
		this.weight_foragingbees = weight_foragingbees;
		this.weight_hive = weight_hive;
		this.weight_colony = weight_colony;
		this.weight_filling_rate = weight_filling_rate;
	}

	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getRecordDate() {
		return recordDate;
	}
	
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	
	public String getIdHive() {
		return idHive;
	}
	
	public void setIdHive(String idHive) {
		this.idHive = idHive;
	}
	
	
	public float getTemp_int_min() {
		return temp_int_min;
	}
	
	public void setTemp_int_min(float temp_int_min) {
		this.temp_int_min = temp_int_min;
	}
	
	public float getTemp_int_max() {
		return temp_int_max;
	}
	
	public void setTemp_int_max(float temp_int_max) {
		this.temp_int_max = temp_int_max;
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



	@Override
	public String toString() {
		return "DailyRecordsW [id=" + id + ", recordDate=" + recordDate + ", idHive=" + idHive + ", temp_int_min="
				+ temp_int_min + ", temp_int_max=" + temp_int_max + ", weight_min=" + weight_min + ", weight_max="
				+ weight_max + ", weight_gain=" + weight_gain + ", weight_income_gain=" + weight_income_gain
				+ ", weight_foragingbees=" + weight_foragingbees + ", weight_hive=" + weight_hive + ", weight_colony="
				+ weight_colony + ", weight_filling_rate=" + weight_filling_rate + "]";
	}
	
	
}
