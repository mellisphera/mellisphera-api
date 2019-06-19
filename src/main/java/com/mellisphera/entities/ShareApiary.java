package com.mellisphera.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SharingApiary")
public class ShareApiary {
	
	@Id
	private String id = null;
	private String idUsername = null; // id du user avec qui sont partager les ruchers
	private String username = null;
	private	ArrayList<Apiary> sharingApiary = null;
	
	public ShareApiary(String id, String idUsername, String username, ArrayList<Apiary> sharingApiary) {
		super();
		this.id = id;
		this.idUsername = idUsername;
		this.username = username;
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
	

	public ArrayList<Apiary> getsharingApiary() {
		return sharingApiary;
	}

	public void setSharingApiary(ArrayList<Apiary> sharingApiary) {
		this.sharingApiary = sharingApiary;
	}
	
	public void addApiary(Apiary apiary) {
		this.sharingApiary.add(apiary);
	}
	
	public Boolean removeApiary(Apiary apiary) {
		return this.sharingApiary.remove(apiary);
	}
	
	@Override
	public String toString() {
		return "["+this.idUsername+"-"+this.sharingApiary+"]";
	}
}
