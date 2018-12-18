package com.apiwatch.entities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Connection")
public class Connection {
	
	private String id=null;
	private Date connectionDate = null;
	private String addr = null;
	private String idUsername = null;
	private Login login = null;
	
	public Connection(Date connectionDate, String addr, String idUsername, Login login) {
		super();
		this.connectionDate = connectionDate;
		this.addr = addr;
		this.idUsername = idUsername;
		this.login = login;
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
	public Login getUsername() {
		return login;
	}
	public void setUsername(Login login) {
		this.login = login;
	}
	@Override
	public String toString() {
		return this.addr+'-'+this.login.getUsername()+'-'+this.connectionDate;
	}
	
}
