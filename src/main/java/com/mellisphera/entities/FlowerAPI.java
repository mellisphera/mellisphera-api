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
