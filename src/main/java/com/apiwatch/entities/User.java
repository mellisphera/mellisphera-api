package com.apiwatch.entities;

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
	private Login login;
	private String username;
	private String password;
	private String phone;
	private String email;
	private long connexions;
	private Date lastConnection;
	private String fullName;
	private String position;
	private String country;
	private String city;
	private int levelUser = 1;

	// ADD for spring security compatibility
	private Set<String> roles = new HashSet<>();
	
	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	// Not Used, no compatible with spring-security
	private final static String[] level = { "ADMIN", "STANDARD", "PREMIUM" };

	public User(String id, Date createdAt, Login login, String phone, String email, long connexions,
			Date lastConnection, String fullName, String position, String city, int levelUser, String country) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.login = login;
		this.phone = phone;
		this.email = email;
		this.connexions = connexions;
		this.lastConnection = lastConnection;
		this.fullName = fullName;
		this.position = position;
		this.country = country;
		this.city = city;
		this.levelUser = levelUser;

	}
	
	public User(String id, Date createdAt, Login login, String phone, String email, long connexions,
			Date lastConnection, String fullName, String position, String city,String country, Set<String> roles) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.login = login;
		this.phone = phone;
		this.email = email;
		this.connexions = connexions;
		this.lastConnection = lastConnection;
		this.fullName = fullName;
		this.position = position;
		this.country = country;
		this.city = city;
		this.roles = roles;

	}

	public static String[] getLevel() {
		return level;
	}

	public int getLevelUser() {
		return levelUser;
	}

	public void setLevelUser(int levelUser) {
		this.levelUser = levelUser;
	}

	public User(Boolean fail) {
		super();
		this.id = null;
		this.createdAt = null;
		this.login = null;
		this.phone = null;
		this.email = null;
		this.connexions = 0;
		this.lastConnection = null;
		this.fullName = null;
		this.position = null;
		this.country = null;
		this.city = null;
		this.levelUser = 1;
	}
	
	public String getUsername() {
		return username;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public void setLogin(Login login) {
		this.login = login;
	}

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

	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}

	public Date getLastConnection() {
		return this.lastConnection;
	}

	public Login getLogin() {
		return this.login;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", createdAt=" + createdAt + ", username=" + login.getUsername() + ", password="
				+ login.getPassword() + ", phone=" + phone + ", email=" + email + ", connexions=" + connexions + "]";
	}

}
