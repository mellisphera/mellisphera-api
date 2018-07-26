package com.apiwatch.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProcessedRecord")
public class ProcessedRecord {
	public String id;
	public float net_weight;
	public float filling_rate;
	public float max_weight_day;
	public float min_weight_day;
	public float max_humidity;
	public float min_humidity;
	public long butineuse_nb;
	public float weight_gain;
	public String idRuche;
	
	public ProcessedRecord() {
		super();
	}
	
	public ProcessedRecord(String id, float net_weight, float filling_rate, float max_weight_day, float min_weight_day,
			float max_humidity, float min_humidity, long butineuse_nb, float weight_gain, String idRuche) {
		super();
		this.id = id;
		this.net_weight = net_weight;
		this.filling_rate = filling_rate;
		this.max_weight_day = max_weight_day;
		this.min_weight_day = min_weight_day;
		this.max_humidity = max_humidity;
		this.min_humidity = min_humidity;
		this.butineuse_nb = butineuse_nb;
		this.weight_gain = weight_gain;
		this.idRuche = idRuche;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getNet_weight() {
		return net_weight;
	}

	public void setNet_weight(float net_weight) {
		this.net_weight = net_weight;
	}

	public float getFilling_rate() {
		return filling_rate;
	}

	public void setFilling_rate(float filling_rate) {
		this.filling_rate = filling_rate;
	}

	public float getMax_weight_day() {
		return max_weight_day;
	}

	public void setMax_weight_day(float max_weight_day) {
		this.max_weight_day = max_weight_day;
	}

	public float getMin_weight_day() {
		return min_weight_day;
	}

	public void setMin_weight_day(float min_weight_day) {
		this.min_weight_day = min_weight_day;
	}

	public float getMax_humidity() {
		return max_humidity;
	}

	public void setMax_humidity(float max_humidity) {
		this.max_humidity = max_humidity;
	}

	public float getMin_humidity() {
		return min_humidity;
	}

	public void setMin_humidity(float min_humidity) {
		this.min_humidity = min_humidity;
	}

	public long getButineuse_nb() {
		return butineuse_nb;
	}

	public void setButineuse_nb(long butineuse_nb) {
		this.butineuse_nb = butineuse_nb;
	}

	public float getWeight_gain() {
		return weight_gain;
	}

	public void setWeight_gain(float weight_gain) {
		this.weight_gain = weight_gain;
	}

	public String getIdRuche() {
		return idRuche;
	}

	public void setIdRuche(String idRuche) {
		this.idRuche = idRuche;
	}
	
	
	
	
	
	
	
	
	
	
}
