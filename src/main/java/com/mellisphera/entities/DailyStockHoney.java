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

@Document(collection = "DailyStockHoney")
public class DailyStockHoney {
	
	@Id
	private String id;
	private String nom;
	private double stockJ;
	private double apportJ;
	private String date;
	private String apiaryId;
	private String hiveId;
	private Long timestamp;
	
	public DailyStockHoney(String id, String nom, double stockJ, double apportJ, String date, String apiaryId,
			String hiveId, Long timestamp) {
		super();
		this.id = id;
		this.nom = nom;
		this.stockJ = stockJ;
		this.apportJ = apportJ;
		this.date = date;
		this.apiaryId = apiaryId;
		this.hiveId = hiveId;
        this.timestamp = timestamp;
	}
	
	public DailyStockHoney() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
        
	public Long getTimestamp(){
		return this.timestamp;
    }
        
    public void setTimestamp(Long newTimestamp){
		this.timestamp = newTimestamp;
    }
                
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getStockJ() {
		return stockJ;
	}
	public void setStockJ(double stockJ) {
		this.stockJ = stockJ;
	}
	public double getApportJ() {
		return apportJ;
	}
	public void setApportJ(double apportJ) {
		this.apportJ = apportJ;
	}       
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getapiaryId() {
		return apiaryId;
	}
	public void setapiaryId(String apiaryId) {
		this.apiaryId = apiaryId;
	}
	public String gethiveId() {
		return hiveId;
	}
	public void sethiveId(String hiveId) {
		this.hiveId = hiveId;
	}
	@Override
	public String toString() {
		return "DailyStockMiel [id=" + id + ", nom=" + nom + ", stockJ=" + stockJ + ", apportJ=" + apportJ + ", date="
				+ date + ", apiaryId=" + apiaryId + ", hiveId=" + hiveId + "]";
	}
	
	
	
}
