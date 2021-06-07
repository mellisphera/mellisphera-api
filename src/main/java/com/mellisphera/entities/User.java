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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Document(collection = "User")
public class User {
	@Id
	private String _id;
	private Date createdAt;
	private String username;
	private String password;
	private String email;
	private long connexions;
	private Date lastConnection;
	private boolean active;
	private UserPref userPref;

	// ADD for spring security compatibility
	private Set<String> roles = new HashSet<>();
	
	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public User(String id, Date createdAt, String username, String password, String email, long connexions,
			Date lastConnection, boolean active, UserPref userPref) {
		super();
		this._id = id;
		this.createdAt = createdAt;
		//this.login = login;
		this.username = username;
		this.password = password;
		this.email = email;
		this.connexions = connexions;
		this.lastConnection = lastConnection;
		this.active = active;
		this.userPref = userPref;

	}

	public User(String id, Date createdAt, String username, String password, String email, long connexions,
			Date lastConnection, UserPref userPref) {
		super();
		this._id = id;
		this.createdAt = createdAt;
		//this.login = login;
		this.username = username;
		this.password = password;
		this.email = email;
		this.connexions = connexions;
		this.lastConnection = lastConnection;
		this.userPref = userPref;

	}
	
	public User(String _id,  Date createdAt, String username, String password, String email, Set<String> roles) {
		super();
		this.createdAt = createdAt;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this._id = _id;
	}
	public User(Boolean fail) {
		super();
		this._id = null;
		this.createdAt = null;
		//this.login = null;
		this.username = null;
		this.password = null;
		this.email = null;
		this.connexions = 0;
		this.lastConnection = null;
	}
	
	public String getUsername() {
		return username;
	}

	
	public UserPref getUserPref() {
		return userPref;
	}

	public void setUserPref(UserPref userPref) {
		this.userPref = userPref;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public User() {
		super();
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}


/**
	public void setLogin(Login login) {
		this.login = login;
	}
	public Login getLogin() {
		return this.login;
	}
**/
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getActive(){
		return this.active;
	}

	public void setActive(boolean act){
		this.active = act;
	}

	public long getConnexions() {
		return connexions;
	}

	public void setConnexions(long connexions) {
		this.connexions = connexions;
	}
	
	public void incrementConnexions() {
		this.connexions++;
	}

	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}

	public Date getLastConnection() {
		return this.lastConnection;
	}



	@Override
	public String toString() {
		return "User{" +
				"id='" + _id + '\'' +
				", createdAt=" + createdAt +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", connexions=" + connexions +
				", lastConnection=" + lastConnection +
				", userPref=" + userPref +
				", roles=" + roles +
				'}';
	}
}
