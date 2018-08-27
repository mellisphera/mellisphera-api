package com.apiwatch.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DailyStockHoney")
public class DailyStockHoney {
	
	@Id
	public String id;
	public String nom;
	public double stockJ;
	public double apportJ;
	public String date;
	public String idApiary;
	public String idHive;
	public String username;
	
	public DailyStockHoney(String id, String nom, double stockJ, double apportJ, String date, String idApiary,
			String idHive, String username) {
		super();
		this.id = id;
		this.nom = nom;
		this.stockJ = stockJ;
		this.apportJ = apportJ;
		this.date = date;
		this.idApiary = idApiary;
		this.idHive = idHive;
		this.username = username;
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
	public String getIdApiary() {
		return idApiary;
	}
	public void setIdApiary(String idApiary) {
		this.idApiary = idApiary;
	}
	public String getIdHive() {
		return idHive;
	}
	public void setIdHive(String idHive) {
		this.idHive = idHive;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "DailyStockMiel [id=" + id + ", nom=" + nom + ", stockJ=" + stockJ + ", apportJ=" + apportJ + ", date="
				+ date + ", idApiary=" + idApiary + ", idHive=" + idHive + ", username=" + username + "]";
	}
	
	
	
}
