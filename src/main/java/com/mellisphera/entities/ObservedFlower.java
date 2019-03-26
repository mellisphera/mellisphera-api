package com.mellisphera.entities;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ObservedFlower")
public class ObservedFlower {

	@Id
	public String id;
	public String nom;
	public HashMap<String,String> dateDebutdate;
	public HashMap<String,String> dateFindate;
	public HashMap<String,String> dateDebutd;
	public HashMap<String,String> dateFind;
	public String dateThDebutd;
	public String dateThFind;
	public String dateThDebutdate;
	public String dateThFindate;
	public String presence;
	public double poid;
	public String username;
	public String idApiary;
	public String photo;

	
	public ObservedFlower() {
	}

	public ObservedFlower(String id, String nom, HashMap<String, String> dateDebutdate,
			HashMap<String, String> dateFindate, HashMap<String, String> dateDebutd, HashMap<String, String> dateFind,
			String dateThDebutd, String dateThFind, String dateThDebutdate, String dateThFindate, String presence,
			double poid, String username, String idApiary, String photo) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateDebutdate = dateDebutdate;
		this.dateFindate = dateFindate;
		this.dateDebutd = dateDebutd;
		this.dateFind = dateFind;
		this.dateThDebutd = dateThDebutd;
		this.dateThFind = dateThFind;
		this.dateThDebutdate = dateThDebutdate;
		this.dateThFindate = dateThFindate;
		this.presence = presence;
		this.poid = poid;
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

	public String getPresence() {
		return presence;
	}
	public void setPresence(String presence) {
		this.presence = presence;
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

	public double getPoid() {
		return poid;
	}

	public void setPoid(double d) {
		this.poid = d;
	}



	public HashMap<String, String> getDateDebutdate() {
		return dateDebutdate;
	}



	public void setDateDebutdate(HashMap<String, String> dateDebutdate) {
		this.dateDebutdate = dateDebutdate;
	}



	public HashMap<String, String> getDateFindate() {
		return dateFindate;
	}



	public void setDateFindate(HashMap<String, String> dateFindate) {
		this.dateFindate = dateFindate;
	}

	
	public void setDateDebutdate(String annee,String dateDebut) {
		this.dateDebutdate.put(annee, dateDebut);
	}
	
	public void setDateFindate(String annee,String dateFin) {
		this.dateFindate.put(annee, dateFin);
	}
	
}
