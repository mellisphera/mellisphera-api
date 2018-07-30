package com.apiwatch.entities;


import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Fleur")
public class ObservedFlower {

	@Id
	public String id;
	public String nom;
	public HashMap<String,Integer> dateDebut;
	public HashMap<String,Integer> dateFin; 
	public HashMap<String,String> dateDebutd;
	public HashMap<String,String> dateFind;
	public int dateThDebut;
	public int dateThFin;
	public String dateThDebutd;
	public String dateThFind;
	public String dateThDebutdate;
	public String dateThFindate;
	public String presence;
	public String username;
	public String idApiary;
	public String photo;

	
	public ObservedFlower() {
	}

	public ObservedFlower(String id, String nom, HashMap<String, Integer> dateDebut, HashMap<String, Integer> dateFin,
			HashMap<String, String> dateDebutd, HashMap<String, String> dateFind, int dateThDebut, int dateThFin,
			String dateThDebutd, String dateThFind, String dateThDebutdate, String dateThFindate, String presence,
			String username, String idApiary, String photo) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateDebutd = dateDebutd;
		this.dateFind = dateFind;
		this.dateThDebut = dateThDebut;
		this.dateThFin = dateThFin;
		this.dateThDebutd = dateThDebutd;
		this.dateThFind = dateThFind;
		this.dateThDebutdate = dateThDebutdate;
		this.dateThFindate = dateThFindate;
		this.presence = presence;
		this.username = username;
		this.idApiary = idApiary;
		this.photo = photo;
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
	public void setDateFin(String annee,Integer dateFin) {
			this.dateFin.put(annee, dateFin);
	}
	public void setDateDebut(String annee,Integer dateDebut) {
		this.dateDebut.put(annee, dateDebut);
}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIdApiary() {
		return idApiary;
	}
	public void setIdApiary(String idApiary) {
		this.idApiary = idApiary;
	}
	public void setDateThDebut(int dateThDebut) {
		this.dateThDebut = dateThDebut;
	}
	public int getDateThFin() {
		return dateThFin;
	}
	public void setDateThFin(int dateThFin) {
		this.dateThFin = dateThFin;
	}
	public String getPresence() {
		return presence;
	}
	public void setPresence(String presence) {
		this.presence = presence;
	}
	public int getDateThDebut() {
		return dateThDebut;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public HashMap<String, String> getDateDebutd() {
		return dateDebutd;
	}

	public void setDateDebutd(HashMap<String, String> dateDebutd) {
		this.dateDebutd = dateDebutd;
	}

	public HashMap<String, String> getDateFind() {
		return dateFind;
	}

	public void setDateFind(HashMap<String, String> dateFind) {
		this.dateFind = dateFind;
	}

	public String getDateThDebutd() {
		return this.dateThDebutd;
	}

	public void setDateThDebutd(String dateThDebutd) {
		this.dateThDebutd = dateThDebutd;
	}

	public String getDateThFind() {
		return this.dateThFind;
	}

	public void setDateThFind(String dateThFind) {
		this.dateThFind = dateThFind;
	}
	
	
	public void setDateDebutd(String annee,String dateDebut) {
		this.dateDebutd.put(annee, dateDebut);
	}
	
	public void setDateFind(String annee,String dateFin) {
		this.dateFind.put(annee, dateFin);
	}


	public HashMap<String, Integer> getDateDebut() {
		return dateDebut;
	}


	public HashMap<String, Integer> getDateFin() {
		return dateFin;
	}


	public String getDateThDebutdate() {
		return dateThDebutdate;
	}


	public void setDateThDebutdate(String dateThDebutdate) {
		this.dateThDebutdate = dateThDebutdate;
	}


	public String getDateThFindate() {
		return dateThFindate;
	}


	public void setDateThFindate(String dateThFindate) {
		this.dateThFindate = dateThFindate;
	}


	public void setDateDebut(HashMap<String, Integer> dateDebut) {
		this.dateDebut = dateDebut;
	}


	public void setDateFin(HashMap<String, Integer> dateFin) {
		this.dateFin = dateFin;
	}

	

	
}
