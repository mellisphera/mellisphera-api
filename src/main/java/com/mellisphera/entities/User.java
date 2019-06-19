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
	private String id;
	private Date createdAt;
	//private Login login;
	private String username;
	private String idUsername;
	private String password;
	private String phone;
	private String email;
	private long connexions;
	private Date lastConnection;
	private String country;
	private String city;
	private UserPref userPref;

	// ADD for spring security compatibility
	private Set<String> roles = new HashSet<>();
	
	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public User(String id, Date createdAt, String username, String password, String phone, String email, long connexions,
			Date lastConnection, String fullName, String position, String city, String country, UserPref userPref, String idUsername) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		//this.login = login;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.connexions = connexions;
		this.idUsername = idUsername;
		this.lastConnection = lastConnection;
		this.country = country;
		this.city = city;
		this.userPref = userPref;

	}
	
	public User( Date createdAt, String username, String password, String email, Set<String> roles) {
		super();
		this.createdAt = createdAt;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;

	}
	public User(Boolean fail) {
		super();
		this.id = null;
		this.createdAt = null;
		//this.login = null;
		this.username = null;
		this.password = null;
		this.phone = null;
		this.email = null;
		this.connexions = 0;
		this.lastConnection = null;
		this.country = null;
		this.city = null;
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
	
	

	public String getIdUsername() {
		return idUsername;
	}

	public void setIdUsername(String idUsername) {
		this.idUsername = idUsername;
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
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "User [id=" + id + ", createdAt=" + createdAt + ", username=" + username + ", password="
				+ password + ", phone=" + phone + ", email=" + email + ", connexions=" + connexions + "]";
	}

}
