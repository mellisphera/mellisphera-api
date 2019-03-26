package com.mellisphera.entities;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SharingApiary")
public class ShareApiary {
	
	@Id
	private String id = null;
	private String idUsername = null; // id du user avec qui sont partager les ruchers
	private Map<String, Apiary>sharingApiary = null; // Map (idHive -> idUser)
	
	public ShareApiary(String id, String idUsername, Map<String, Apiary> sharingApiary) {
		super();
		this.id = id;
		this.idUsername = idUsername;
		this.sharingApiary = sharingApiary;
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


	public void setIdUsername(String idUsername) {
		this.idUsername = idUsername;
	}
	

	public Map<String, Apiary> getsharingApiary() {
		return sharingApiary;
	}

	public void setSharingApiary(Map<String, Apiary> sharingApiary) {
		this.sharingApiary = sharingApiary;
	}
	
	public void addApiary(Apiary apiary, String idUsername) {
		this.sharingApiary.put(idUsername, apiary);
	}
	
	public Boolean removeApiary(Apiary apiary, String idUser) {
		return this.sharingApiary.remove(idUser, apiary);
	}
	
	
	public String toString() {
		return "["+this.idUsername+"-"+this.sharingApiary+"]";
	}
}
