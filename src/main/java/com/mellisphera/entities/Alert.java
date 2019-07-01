package com.mellisphera.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Alert")
public class Alert {

	/*
	 *     "_id" : ObjectId("5d0e2face632a881d8d48181"),
    "idUser" : "5bcddaa20721ec0d5ac1fde0",
    "user" : "lpo",
    "apiary" : "Guindalos",
    "hive" : "R6",
    "type" : "Daily",
    "alert" : "Changement important du poids pour Guindalos-R6",
    "message" : "Alerte - Le poids a varié de plus de 5kg lors des derniers jours! Vous devriez aller vérifier votre ruche.",
    "date" : ISODate("2019-06-21T00:00:00.000Z")
	 * */
	
	private String _id;
	private String idUser;
	private String user;
	private String apiary;
	private String idApiary;
	private String idHive;
	private String hive;
	private String type;
	private String time;
	private String loc;
	private String alert;
	private String message;
	private Date date;
	private Boolean check;
	
	public Alert() {
		// TODO Auto-generated constructor stub
	}

	
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getLoc() {
		return loc;
	}


	public void setLoc(String loc) {
		this.loc = loc;
	}


	public String get_id() {
		return _id;
	}

	public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getApiary() {
		return apiary;
	}

	public void setApiary(String apiary) {
		this.apiary = apiary;
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

	public String getHive() {
		return hive;
	}

	public void setHive(String hive) {
		this.hive = hive;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
}

