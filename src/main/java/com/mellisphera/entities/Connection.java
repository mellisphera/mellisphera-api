package com.mellisphera.entities;

import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mellisphera.security.entities.GeoIp;

@Document(collection = "Connection")
public class Connection {

	private String id = null;
	private Date connectionDate = null;
	private String idUsername = null;
	private String username;
	private GeoIp location = null;

	public Connection(Date connectionDate, String idUsername, String username,
			GeoIp location) {
		super();
		this.connectionDate = connectionDate;
		this.idUsername = idUsername;
		this.username = username;
		this.location = location;
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

	public String getIdUsername() {
		return idUsername;
	}

	public void setIdUsername(String idUsername) {
		this.idUsername = idUsername;
	}
	

	public GeoIp getLocation() {
		return location;
	}

	public void setLocation(GeoIp location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "{ username : "+this.username + ",\n location :"+this.location+"}";
	}

}
