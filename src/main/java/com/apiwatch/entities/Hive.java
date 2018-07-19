package com.example.demo.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Hive")
public class Hive {

		public String id;
		public String name ;
		public String description;
		public Apiary apiary;
		public String username; 
		public String idApiary;
		
		
		
		public Hive() {
			super();
		}

		public Hive(String id, String name, String description, Apiary apiary, String username, String idApiary) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.apiary = apiary;
			this.username = username;
			this.idApiary = idApiary;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
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

		public Apiary getApiary() {
			return apiary;
		}

		public void setApiary(Apiary apiary) {
			this.apiary = apiary;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getIdApiary() {
			return idApiary;
		}

		public void setIdApiary(String idApiary) {
			this.idApiary = idApiary;
		}

		@Override
		public String toString() {
			return "Hive [id=" + id + ", name=" + name + ", description=" + description + ", apiary=" + apiary
					+ ", username=" + username + ", idApiary=" + idApiary + "]";
		}
		
		
		
	
	
	
}
