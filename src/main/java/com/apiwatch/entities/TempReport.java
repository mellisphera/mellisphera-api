package com.apiwatch.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tempReport")
public class TempReport {

	public String sentence;
	public List<String> ruche;
	public String idApiary;
	public String type;
	
	public TempReport() {
		super();
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
		
	
	

}
