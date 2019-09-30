package com.mellisphera.entities;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Note")
public class Note {

	@Id
	private String _id;
	private Timestamp createDate;
	private String type;
	private String[] tags;
	private String description;
	private String hiveId;
	private String apiaryId;
	private Timestamp opsDate;
	private String idUsername;


	public Note() {
		
	}


	public Note(String _id,
				Timestamp createDate,
				String type,
				String[] tags,
				String description,
				String hiveId,
				String apiaryId,
				Timestamp opsDate,
				String idUsername
		) {
		this._id = _id;
		this.createDate = createDate;
		this.type = type;
		this.tags = tags;
		this.idUsername = idUsername;
		this.description = description;
		this.hiveId = hiveId;
		this.apiaryId = apiaryId;
		this.opsDate = opsDate;
	}

	public String get_id() {
		return _id;
	}

	public String getIdUsername() {
		return idUsername;
	}

	public void setIdUsername(String idUsername) {
		this.idUsername = idUsername;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
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

	public Timestamp getOpsDate() {
		return opsDate;
	}

	public void setOpsDate(Timestamp opsDate) {
		this.opsDate = opsDate;
	}
}
