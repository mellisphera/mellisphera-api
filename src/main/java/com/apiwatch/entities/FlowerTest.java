package com.example.demo.entities;

public class FlowerTest {
	public Flower flowerApi;
	public FlowerITSAP flowerItsap;
	public String type;
	public String commentaire;
	public String photo;
	
	public FlowerTest(Flower flowerApi, FlowerITSAP flowerIstap, String type) {
		super();
		this.flowerApi = flowerApi;
		this.flowerItsap = flowerIstap;
		this.type = type;
	}
	
	public FlowerTest() {
		// TODO Auto-generated constructor stub
	}

	public Flower getFlowerApi() {
		return flowerApi;
	}
	public void setFlowerApi(Flower flowerApi) {
		this.flowerApi = flowerApi;
	}
	public FlowerITSAP getFlowerIstap() {
		return flowerItsap;
	}
	public void setFlowerIstap(FlowerITSAP flowerItsap) {
		this.flowerItsap = flowerItsap;
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
