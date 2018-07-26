package com.apiwatch.entities;

import java.util.List;

//the Resttemplate class needs the same return format of the query
//http://apibotanica.inra.fr/botaniqueDB.json

//this class is made for storing the result from the query of API Botanica
//via the ResTemplate 
public class FlowerAPI {
	public List<Flower> result;

	public FlowerAPI() {
		super();
	}

	public List<Flower> getResult() {
		return result;
	}

	public void setResult(List<Flower> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Result [result=" + result + "]";
	}
	
	
}
