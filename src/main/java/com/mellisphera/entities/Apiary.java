package com.mellisphera.entities;

import java.io.File;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Apiary")
public class Apiary {

	@Id
	private String _id;
	private String name;
	private String description;
	private String zipCode;
	private Boolean privateApiary;
	private String city;
	private String idUser;
	private Timestamp createDate;
	private String countryCode;
	private String photo;
	private Timestamp dataLastReceived;
	private String username; 
	private List<User> sharedWith;
	
	
	public Apiary() {
		super();
	}

	public Apiary(String _id, String name, String description, String zipCode, Boolean privateApiary, String city, String idUser, Timestamp createDate, String countryCode, String photo, Timestamp dataLastReceived, String username, List<User> sharedWith) {
		this._id = _id;
		this.name = name;
		this.description = description;
		this.zipCode = zipCode;
		this.privateApiary = privateApiary;
		this.city = city;
		this.idUser = idUser;
		this.createDate = createDate;
		this.countryCode = countryCode;
		this.photo = photo;
		this.dataLastReceived = dataLastReceived;
		this.username = username;
		this.sharedWith = sharedWith;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Boolean getPrivateApiary() {
		return privateApiary;
	}

	public void setPrivateApiary(Boolean privateApiary) {
		this.privateApiary = privateApiary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Timestamp getDataLastReceived() {
		return dataLastReceived;
	}

	public void setDataLastReceived(Timestamp dataLastReceived) {
		this.dataLastReceived = dataLastReceived;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<User> getSharedWith() {
		return sharedWith;
	}

	public void setSharedWith(List<User> sharedWith) {
		this.sharedWith = sharedWith;
	}
}
