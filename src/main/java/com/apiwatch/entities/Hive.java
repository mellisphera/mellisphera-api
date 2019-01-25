package com.apiwatch.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Hive")
public class Hive {

		private String id;
		private String name ;
		private String description;
		private Apiary apiary;
		private String username; 
		private String idApiary;
		private float hivePosX;
		private float hivePosY;
		private User[] sharingUser;
		private Boolean shareStatus = false;
		
		public Hive() {
			super();
		}

		public Hive(String id, String name, String description, Apiary apiary, String username, String idApiary, String hivePosX, String hivePosY, Boolean shareStatus, User[] sharingUser) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			this.apiary = apiary;
			this.username = username;
			this.idApiary = idApiary;
			this.hivePosX = Float.parseFloat(hivePosX);
			this.hivePosY = Float.parseFloat(hivePosY);
			this.shareStatus = shareStatus;
			this.sharingUser = sharingUser;
		}

		public User[] getSharingUser() {
			return sharingUser;
		}

		public void setSharingUser(User[] sharingUser) {
			this.sharingUser = sharingUser;
		}

		public String getId() {
			return id;
		}

		public Boolean getShareStatus() {
			return shareStatus;
		}

		public void setShareStatus(Boolean shareStatus) {
			this.shareStatus = shareStatus;
		}

		public void setHivePosX(float hivePosX) {
			this.hivePosX = hivePosX;
		}

		public void setHivePosY(float hivePosY) {
			this.hivePosY = hivePosY;
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
		
		public String getHivePosX() {
			return ""+this.hivePosX;
		}
		
		public String getHivePosY() {
			return ""+this.hivePosY;
		}
		public void setHivePos(String x, String y) {
			this.hivePosX = Float.parseFloat(x);
			this.hivePosY = Float.parseFloat(y);
		}
		
		public void addSharingUser(User user) {
			this.sharingUser[this.sharingUser.length] = user;
		}
		@Override
		public String toString() {
			return "Hive [id=" + id + ", name=" + name + ", description=" + description + ", apiary=" + apiary
					+ ", username=" + username + ", idApiary=" + idApiary+"]";
		}
		
		
		
	
	
	
}
