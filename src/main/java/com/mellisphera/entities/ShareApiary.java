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
	private String _id = null;
	private String userId = null; // _id du user avec qui sont partager les ruchers
	private	List<Apiary> sharingApiary = null;
	
	public ShareApiary(String _id, String userId, List<Apiary> sharingApiary) {
		super();
		this._id = _id;
		this.userId = userId;
		this.sharingApiary = sharingApiary;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getuserId() {
		return userId;
	}


	public void setuserId(String userId) {
		this.userId = userId;
	}
	

	public List<Apiary> getsharingApiary() {
		return sharingApiary;
	}

	public void setSharingApiary(List<Apiary> sharingApiary) {
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
