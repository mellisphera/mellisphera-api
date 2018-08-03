package com.apiwatch.entities;

public class TheoricalFlower {

	public FlowerINRA flowerApi;
	public FlowerITSAP flowerItsap;
	public String type;
	public String commentaire;
	public String photo;
	
	public TheoricalFlower(FlowerINRA flowerApi, FlowerITSAP flowerItsap, String type, String commentaire, String photo) {
		super();
		this.flowerApi = flowerApi;
		this.flowerItsap = flowerItsap;
		this.type = type;
		this.commentaire = commentaire;
		this.photo = photo;
	}
	
	public TheoricalFlower() {
		// TODO Auto-generated constructor stub
	}

	public FlowerINRA getFlowerApi() {
		return flowerApi;
	}
	public void setFlowerApi(FlowerINRA flowerApi) {
		this.flowerApi = flowerApi;
	}
	
	@Override
	public String toString() {
		return "FlowerTest [flowerApi=" + flowerApi + ", flowerIstap=" + flowerItsap + "]";
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
