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

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="kpisynclog")
public class Kpisynclog {
	
	@Id
	private String _id;
	private String user;
	private Date date;
	private int lastSync;
	private String inscription;
	private int nbLogBM;
	private int nbLogMS;
	private int nbLogTot;
	private int nbLogUnknown;
	private int lastLog;
	private Date createdAt;

	public Kpisynclog(String _id, String user, Date date, int lastSync, String inscription, int nbLogBM, int nbLogMS, int nbLogTot, int nbLogUnknown, int lastLog, Date createdAt) {
		this._id = _id;
		this.user = user;
		this.date = date;
		this.lastSync = lastSync;
		this.inscription = inscription;
		this.nbLogBM = nbLogBM;
		this.nbLogMS = nbLogMS;
		this.nbLogTot = nbLogTot;
		this.nbLogUnknown = nbLogUnknown;
		this.lastLog = lastLog;
		this.createdAt = createdAt;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getLastSync() {
		return lastSync;
	}

	public void setLastSync(int lastSync) {
		this.lastSync = lastSync;
	}

	public String getInscription() {
		return inscription;
	}

	public void setInscription(String inscription) {
		this.inscription = inscription;
	}

	public int getNbLogBM() {
		return nbLogBM;
	}

	public void setNbLogBM(int nbLogBM) {
		this.nbLogBM = nbLogBM;
	}

	public int getNbLogMS() {
		return nbLogMS;
	}

	public void setNbLogMS(int nbLogMS) {
		this.nbLogMS = nbLogMS;
	}

	public int getNbLogTot() {
		return nbLogTot;
	}

	public void setNbLogTot(int nbLogTot) {
		this.nbLogTot = nbLogTot;
	}

	public int getNbLogUnknown() {
		return nbLogUnknown;
	}

	public void setNbLogUnknown(int nbLogUnknown) {
		this.nbLogUnknown = nbLogUnknown;
	}

	public int getLastLog() {
		return lastLog;
	}

	public void setLastLog(int lastLog) {
		this.lastLog = lastLog;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
