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
	private int lastLog;
	private Date createdAt;
	
	

	public Kpisynclog(String _id, String user, Date date, int lastSync, int lastLog, Date createdAt) {
		super();
		this._id = _id;
		this.user = user;
		this.date = date;
		this.lastSync = lastSync;
		this.lastLog = lastLog;
		this.createdAt = createdAt;
	}

	public String get_id() {
		return _id;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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

	public int getLastLog() {
		return lastLog;
	}

	public void setLastLog(int lastLog) {
		this.lastLog = lastLog;
	}


}
