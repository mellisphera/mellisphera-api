package com.apiwatch.entities;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProcessReportTemp")
public class ProcessReportTemp {

	public String id;
	public String sentence;
	public List<String> ruche;
	public String[] idLHive;
	public String idHive;
	public String idApiary;
	public String type;
	public String date;
	public String username;

	
	public String getId() {
		return id;
	}
	
	
	public ProcessReportTemp(String id, String sentence, List<String> ruche, String[] idLHive, String idHive,
			String idApiary, String type, String date) {
		super();
		this.id = id;
		this.sentence = sentence;
		this.ruche = ruche;
		this.idLHive = idLHive;
		this.idHive = idHive;
		this.idApiary = idApiary;
		this.type = type;
		this.date = date;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	public List<String> getRuche() {
		return ruche;
	}
	public void setRuche(List<String> ruche) {
		this.ruche = ruche;
	}
	public String[] getIdLHive() {
		return idLHive;
	}
	public void setIdLHive(String[] idLHive) {
		this.idLHive = idLHive;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
