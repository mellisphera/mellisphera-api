package com.example.demo.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Post {
	@Id
	public String id;
	public String title;
	public String content;
	public Date created_at;
	public int loveIts;
	
	public Post() {
		super();
	}
	public Post(String id, String title, String content, Date created_at, int loveIts) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.created_at = created_at;
		this.loveIts = loveIts;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", created_at=" + created_at
				+ ", loveIts=" + loveIts + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public int getLoveIts() {
		return loveIts;
	}
	public void setLoveIts(int loveIts) {
		this.loveIts = loveIts;
	}
	
	
	
}
