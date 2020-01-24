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
    "icon" : "Daily",
    "alert" : "Changement important du poids pour Guindalos-R6",
    "message" : "Alerte - Le poids a varié de plus de 5kg lors des derniers jours! Vous devriez aller vérifier votre ruche.",
    "date" : ISODate("2019-06-21T00:00:00.000Z")
	 * */

	private String _id;
	private String userId;
	private String user;
	private String apiaryName;
	private String apiaryId;
	private String hiveId;
	private String hiveName;
	private String icon;
	private String time;
	private String loc;
	private String code;
	private String notif;
	private String message;
	private Date opsDate;
	private String sensorRef;
	private Boolean check;

	public AlertSent() {}

    public AlertSent(String _id, String userId, String user, String apiaryName, String apiaryId, String hiveId, String hiveName, String icon, String time, String loc, String code, String notif, String message, Date opsDate, String sensorRef, Boolean check) {
        this._id = _id;
        this.userId = userId;
        this.user = user;
        this.apiaryName = apiaryName;
        this.apiaryId = apiaryId;
        this.hiveId = hiveId;
        this.hiveName = hiveName;
        this.icon = icon;
        this.time = time;
        this.loc = loc;
        this.code = code;
        this.notif = notif;
        this.message = message;
        this.opsDate = opsDate;
        this.sensorRef = sensorRef;
        this.check = check;
    }

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

    public String getApiaryName() {
        return apiaryName;
    }

    public void setApiaryName(String apiaryName) {
        this.apiaryName = apiaryName;
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

    public String getHiveName() {
        return hiveName;
    }

    public void setHiveName(String hiveName) {
        this.hiveName = hiveName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNotif() {
        return notif;
    }

    public void setNotif(String notif) {
        this.notif = notif;
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

    public String getSensorRef() {
        return sensorRef;
    }

    public void setSensorRef(String sensorRef) {
        this.sensorRef = sensorRef;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
}

