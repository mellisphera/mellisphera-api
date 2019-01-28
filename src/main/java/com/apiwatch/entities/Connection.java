package com.apiwatch.entities;

import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Connection")
public class Connection {

	private String id = null;
	private Date connectionDate = null;
	private String addr = null;
	private String idUsername = null;
	private String username;

	private String password;
	private Location location = null;

	public Connection(Date connectionDate, String addr, String idUsername, String username, String password,
			Location location) {
		super();
		this.connectionDate = connectionDate;
		this.addr = addr;
		this.idUsername = idUsername;
		this.username = username;
		this.password = password;
		this.location = location;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(Date connectionDate) {
		this.connectionDate = connectionDate;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getIdUsername() {
		return idUsername;
	}

	public void setIdUsername(String idUsername) {
		this.idUsername = idUsername;
	}

	@Override
	public String toString() {
		return this.addr + '-' + this.getUsername() + '-' + this.connectionDate;
	}

}
