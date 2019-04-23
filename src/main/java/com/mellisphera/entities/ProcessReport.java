package com.mellisphera.entities;

import java.sql.Array;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProcessReport")
public class ProcessReport {


	private String id;
	private Date date;
	private String type;
	private String sentence;
	private String[] idLHive;
	private List<String> ruche;
	private String idHive;
	private String idApiary;
	private String nluScore;
	private String username;
	
	public ProcessReport() {
		
	}
	
	public ProcessReport(String id, Date date, String type, String sentence,String[] idLHive, List<String> ruche,
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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

	public void setUsername(String username) {
		this.username = username;
		
	}
	
	
	
	
}
