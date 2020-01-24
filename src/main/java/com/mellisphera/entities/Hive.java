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

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.Date;

@Document(collection = "Hive")
public class Hive {

		@Id
		private String _id;
		private String name ;
		private String description;
		private String username;
		private String apiaryId;
		private String userId;
		private Boolean hidden;
		private Date dataLastReceived;
		private Date createDate;
		private float hivePosX;
		private float hivePosY;

		public Hive() {
			super();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApiaryId() {
		return apiaryId;
	}

	public void setApiaryId(String apiaryId) {
		this.apiaryId = apiaryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public Date getDataLastReceived() {
		return dataLastReceived;
	}

	public void setDataLastReceived(Date dataLastReceived) {
		this.dataLastReceived = dataLastReceived;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public float getHivePosX() {
		return hivePosX;
	}

	public void setHivePosX(float hivePosX) {
		this.hivePosX = hivePosX;
	}

	public float getHivePosY() {
		return hivePosY;
	}

	public void setHivePosY(float hivePosY) {
		this.hivePosY = hivePosY;
	}

	@Override
	public String toString() {
		return "Hive{" +
				"_id='" + _id + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", username='" + username + '\'' +
				", apiaryId='" + apiaryId + '\'' +
				", userId='" + userId + '\'' +
				", hidden=" + hidden +
				", dataLastReceived=" + dataLastReceived +
				", createDate=" + createDate +
				", hivePosX=" + hivePosX +
				", hivePosY=" + hivePosY +
				'}';
	}
}
