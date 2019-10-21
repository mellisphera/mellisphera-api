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

import java.sql.Array;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Note")
public class Note {

	@Id
	private String _id;
	private Date createDate;
	private String type;
	private String[] tags;
	private String description;
	private String hiveId;
	private String apiaryId;
	private Date opsDate;
	private String userId;
	private String typeInspect;


	public Note() {
		
	}


	public Note(String _id,
				Date createDate,
				String type,
				String[] tags,
				String description,
				String hiveId,
				String apiaryId,
				String typeInspect,
				Date opsDate,
				String userId
		) {
		this._id = _id;
		this.createDate = createDate;
		this.type = type;
		this.tags = tags;
		this.userId = userId;
		this.description = description;
		this.typeInspect = typeInspect;
		this.hiveId = hiveId;
		this.apiaryId = apiaryId;
		this.opsDate = opsDate;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHiveId() {
		return hiveId;
	}

	public void setHiveId(String hiveId) {
		this.hiveId = hiveId;
	}

	public String getApiaryId() {
		return apiaryId;
	}

	public void setApiaryId(String apiaryId) {
		this.apiaryId = apiaryId;
	}

	public Date getOpsDate() {
		return opsDate;
	}

	public void setOpsDate(Date opsDate) {
		this.opsDate = opsDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTypeInspect() {
		return typeInspect;
	}

	public void setTypeInspect(String typeInspect) {
		this.typeInspect = typeInspect;
	}
}
