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
		return "{ Date: "+ this.connectionDate +"username : "+this.username + ",\n location :"+this.location+"}";
	}

}
