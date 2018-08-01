package com.apiwatch.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OneFlower")
public class OneObservedFlower {
	
	@Id
	public String id;
	public String nom;
	public int dateDebut; //A transformer en date
	public int dateFin;   //A transformer en date
	public String dateDebutd; 
	public String dateFind;
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
	
	

	public OneObservedFlower() {
	}
	
	public OneObservedFlower(String id, String nom, int dateDebut, int dateFin, String dateDebutd, String dateFind,
			int dateThDebut, int dateThFin, String dateThDebutd, String dateThFind, String dateThDebutdate,
			String dateThFindate, String presence, String username, String idApiary, String photo) {
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

	public int getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(int dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDateFin() {
		return dateFin;
	}

	public void setDateFin(int dateFin) {
		this.dateFin = dateFin;
	}

	public int getDateThDebut() {
		return dateThDebut;
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

	@Override
	public String toString() {
		return "OneObservedFlower [id=" + id + ", nom=" + nom + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", dateThDebut=" + dateThDebut + ", dateThFin=" + dateThFin + ", presence=" + presence + ", username="
				+ username + ", idApiary=" + idApiary + "]";
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDateDebutd() {
		return dateDebutd;
	}

	public void setDateDebutd(String dateDebutd) {
		this.dateDebutd = dateDebutd;
	}

	public String getDateFind() {
		return dateFind;
	}

	public void setDateFind(String dateDebutf) {
		this.dateFind = dateDebutf;
	}

	public String getDateThDebutd() {
		return dateThDebutd;
	}

	public void setDateThDebutd(String dateThDebutd) {
		this.dateThDebutd = dateThDebutd;
	}

	public String getDateThFind() {
		return dateThFind;
	}

	public void setDateThFind(String dateThFind) {
		this.dateThFind = dateThFind;
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
	
	
	
}
