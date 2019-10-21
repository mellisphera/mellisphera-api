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

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OneObservedFlower")
public class OneObservedFlower {
	
	@Id
	public String id;
	public String nom;
	public String dateDebutd; 
	public String dateFind;
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
	
	public OneObservedFlower(String id, String nom,  String dateDebutd, String dateFind,
			String dateThDebutd, String dateThFind, String dateThDebutdate,
			String dateThFindate, String presence, String username, String idApiary, String photo) {
		super();
		this.id = id;
		this.nom = nom;
		this.dateDebutd = dateDebutd;
		this.dateFind = dateFind;
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
