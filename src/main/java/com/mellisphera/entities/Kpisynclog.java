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
