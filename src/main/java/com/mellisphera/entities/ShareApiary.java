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
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SharingApiary")
public class ShareApiary {
	
	@Id
	private String id = null;
	private String userId = null; // id du user avec qui sont partager les ruchers
	private String username = null;
	private	ArrayList<Apiary> sharingApiary = null;
	
	public ShareApiary(String id, String userId, String username, ArrayList<Apiary> sharingApiary) {
		super();
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.sharingApiary = sharingApiary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getuserId() {
		return userId;
	}


	public void setuserId(String userId) {
		this.userId = userId;
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
		return "["+this.userId+"-"+this.sharingApiary+"]";
	}
}
