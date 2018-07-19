package com.apiwatch.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {
	@Id
	public String id;
	public Date createdAt ;
	public String username;
	public String password;
	public String phone;
	public String email;
	public long connexions;
	
	
	public User(String id, Date createdAt, String username, String password, String phone, String email,
			long connexions) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.connexions = connexions;
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
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", createdAt=" + createdAt + ", username=" + username + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", connexions=" + connexions + "]";
	}
	
	 
}
