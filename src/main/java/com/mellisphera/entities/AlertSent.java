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

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AlertSent")
public class AlertSent {

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
	private String userId;
	private String user;
	private String apiary;
	private String apiaryId;
	private String hiveId;
	private String hive;
	private String type;
	private String time;
	private String loc;
	private String alert;
	private String message;
	private Date opsDate;
	private Boolean check;

	public AlertSent(String _id, String userId, String user, String apiary, String apiaryId, String hiveId, String hive, String type, String time, String loc, String alert, String message, Date opsDate, Boolean check) {
		this._id = _id;
		this.userId = userId;
		this.user = user;
		this.apiary = apiary;
		this.apiaryId = apiaryId;
		this.hiveId = hiveId;
		this.hive = hive;
		this.type = type;
		this.time = time;
		this.loc = loc;
		this.alert = alert;
		this.message = message;
		this.opsDate = opsDate;
		this.check = check;
	}

	public AlertSent() {}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getApiaryId() {
		return apiaryId;
	}

	public void setApiaryId(String apiaryId) {
		this.apiaryId = apiaryId;
	}

	public String getHiveId() {
		return hiveId;
	}

	public void setHiveId(String hiveId) {
		this.hiveId = hiveId;
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

	public Date getOpsDate() {
		return opsDate;
	}

	public void setOpsDate(Date opsDate) {
		this.opsDate = opsDate;
	}

	public Boolean getCheck() {
		return check;
	}

	public void setCheck(Boolean check) {
		this.check = check;
	}
}

