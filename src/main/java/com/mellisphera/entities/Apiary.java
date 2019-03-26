package com.mellisphera.entities;

import java.io.File;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Apiary")
public class Apiary {

	@Id
	private String id;
	private float latitude;
	private float longitude;
	private String name;
	private String description;
	private String codePostal;
	private String ville;
	private Date createdAt;
	private String photo;
	private String username; 
	private User user;
	private List<User> sharedWith;
	
	
	public Apiary() {
		super();
	}
	
	public Apiary(String id, float latitude, float longitude, String name, String description, String codePostal,
			String ville, Date createdAt, String photo, String username, User user, List<User>  sharedWith) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.description = description;
		this.codePostal = codePostal;
		this.ville = ville;
		this.createdAt = createdAt;
		this.photo = photo;
		this.username = username;
		this.user = user;
		this.sharedWith = sharedWith;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getSharedWith() {
		return this.sharedWith;
	}
	public void setSharedWith(List<User>  sharedWith) {
		this.sharedWith = sharedWith;
	}

	public void addSharedUser(User user) {
		this.sharedWith.add(user);
	}
	
	public Boolean removeSharedUser(User user) {
		return this.sharedWith.remove(user);
	}
	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public String toString() {
		return "Apiary [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", name=" + name
				+ ", description=" + description + ", codePostal=" + codePostal + ", ville=" + ville + ", createdAt="
				+ createdAt + ", photo=" + photo + ", username=" + username + ", user=" + user  + "]";
	}
	
}
