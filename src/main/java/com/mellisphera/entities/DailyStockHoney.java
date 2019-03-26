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
	private String idApiary;
	private String idHive;
	private Long timestamp;
	
	public DailyStockHoney(String id, String nom, double stockJ, double apportJ, String date, String idApiary,
			String idHive, Long timestamp) {
		super();
		this.id = id;
		this.nom = nom;
		this.stockJ = stockJ;
		this.apportJ = apportJ;
		this.date = date;
		this.idApiary = idApiary;
		this.idHive = idHive;
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
	@Override
	public String toString() {
		return "DailyStockMiel [id=" + id + ", nom=" + nom + ", stockJ=" + stockJ + ", apportJ=" + apportJ + ", date="
				+ date + ", idApiary=" + idApiary + ", idHive=" + idHive + "]";
	}
	
	
	
}
