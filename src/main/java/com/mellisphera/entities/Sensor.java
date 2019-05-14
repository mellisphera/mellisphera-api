package com.mellisphera.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "Sensor")
public class Sensor {
	@Id
	private String id;
	private String sensorRef;
	//public String name;
	private String type;
	private String description;
	private String idHive ;
	private String idApiary;
	private String apiaryName;
	private String hiveName;
	private String username;
	
	
	public Sensor() {
		super();
	}


	public Sensor(String id, String sensorRef, /*String name,*/ String type, String description, String idHive,
			String idApiary, String apiaryName, String hiveName, String username) {
		super();
		this.id = id;
		this.sensorRef = sensorRef;
		//this.name = name;
		this.type = type;
		this.description = description;
		this.idHive = idHive;
		this.idApiary = idApiary;
		this.apiaryName = apiaryName;
		this.hiveName = hiveName;
		this.username = username;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getSsensorRef() {
		return sensorRef;
	}


	public void setSensorRef(String sensorRef) {
		this.sensorRef = sensorRef;
	}


	/*public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
*/

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIdHive() {
		return idHive;
	}


	public void setIdHive(String idHive) {
		this.idHive = idHive;
	}


	public String getIdApiary() {
		return idApiary;
	}


	public void setIdApiary(String idApiary) {
		this.idApiary = idApiary;
	}


	public String getApiaryName() {
		return apiaryName;
	}


	public void setApiaryName(String apiaryName) {
		this.apiaryName = apiaryName;
	}


	public String getHiveName() {
		return hiveName;
	}


	public void setHiveName(String hiveName) {
		this.hiveName = hiveName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
