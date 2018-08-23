package com.apiwatch.entities;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

//the Resttemplate class needs the same return format of the query
//http://apibotanica.inra.fr/botaniqueDB.json

//this class is made for storing the result from the query of API Botanica
//via the ResTemplate 
@Document(collection = "FlowerAPI")
public class FlowerAPI {
	public List<FlowerINRA> result;

	public FlowerAPI() {
		super();
	}

	public List<FlowerINRA> getResult() {
		return result;
	}

	public void setResult(List<FlowerINRA> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Result [result=" + result + "]";
	}
	
	
}
