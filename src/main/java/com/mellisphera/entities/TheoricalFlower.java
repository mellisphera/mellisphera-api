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

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TheoricalFlower")
public class TheoricalFlower {

	public FlowerINRA flowerInra;
	public FlowerITSAP flowerItsap;
	public String type;
	public String commentaire;
	public String photo;
	
	public TheoricalFlower(FlowerINRA flowerInra, FlowerITSAP flowerItsap, String type, String commentaire, String photo) {
		super();
		this.flowerInra = flowerInra;
		this.flowerItsap = flowerItsap;
		this.type = type;
		this.commentaire = commentaire;
		this.photo = photo;
	}
	
	public TheoricalFlower() {
		// TODO Auto-generated constructor stub
	}

	public FlowerINRA getFlowerApi() {
		return flowerInra;
	}
	public void setFlowerApi(FlowerINRA flowerInra) {
		this.flowerInra = flowerInra;
	}
	
	@Override
	public String toString() {
		return "FlowerTest [flowerInra=" + flowerInra + ", flowerIstap=" + flowerItsap + "]";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FlowerITSAP getFlowerItsap() {
		return flowerItsap;
	}

	public void setFlowerItsap(FlowerITSAP flowerItsap) {
		this.flowerItsap = flowerItsap;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
