package com.apiwatch.entities;

import java.sql.Array;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProcessReport")
public class ProcessReport {


	public String id;
	public String date;
	public String type;
	public String sentence;
	public String[] idLHive;
	public List<String> ruche;
	public String idHive;
	public String idApiary;
	public String nluScore;
	public String username;
	
	public ProcessReport() {
		
	}
	
	public ProcessReport(String id, String date, String type, String sentence,String[] idLHive, List<String> ruche,
			String idHive, String idApiary, String nluScore) {
		super();
		this.id = id;
		this.date = date;
		this.type = type;
		this.sentence = sentence;
		this.idLHive = idLHive;
		this.ruche = ruche;
		this.idHive = idHive;
		this.idApiary = idApiary;
		this.nluScore = nluScore;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public String[] getIdLHive() {
		return idLHive;
	}
	public void setIdLHive(String[] idLHive) {
		this.idLHive = idLHive;
	}
	
	public List<String> getRuche() {
		return ruche;
	}
	public void setRuche(List<String> ruche) {
		this.ruche = ruche;
	}
	public String getIdHive() {
		return idHive;
	}
	public void setIdHive(String idHive) {
		this.idHive = idHive;
	}
	public String getIdApiary() {
		return idApiary;
	}
	public void setIdApiary(String idApiary) {
		this.idApiary = idApiary;
	}
	public String getNluScore() {
		return nluScore;
	}
	public void setNluScore(String nluScore) {
		this.nluScore = nluScore;
	}
	
	
	
	
}
