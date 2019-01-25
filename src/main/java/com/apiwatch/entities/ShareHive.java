package com.apiwatch.entities;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SharingHives")
public class ShareHive {
	
	@Id
	private String id = null;
	private String idUsername = null; // id du user avec qui sont partager les ruches
	private String username = null;
	private Map<String, Hive>hiveShare = null; // Map (idHive -> idUser)
	
	public ShareHive(String id, String idUsername, String username, Map<String, Hive> hiveShare) {
		super();
		this.id = id;
		this.idUsername = idUsername;
		this.hiveShare = hiveShare;
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdUsername() {
		return idUsername;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setIdUsername(String idUsername) {
		this.idUsername = idUsername;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public Map<String, Hive> gethiveShare() {
		return hiveShare;
	}

	public void sethiveShare(Map<String, Hive> hiveShare) {
		this.hiveShare = hiveShare;
	}
	
	public void addHive(Hive hive, String idUsername) {
		this.hiveShare.put(idUsername, hive);
	}
	
	public Boolean removeHive(Hive hive, String idUser) {
		return this.hiveShare.remove(idUser, hive);
	}
	
	
	public String toString() {
		return "["+this.idUsername+"-"+this.hiveShare+"]";
	}
}
