package com.apiwatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.apiwatch.repositories.ConnectionRepository;

public class ConnectionController{
	
	@Autowired
	private ConnectionRepository connectionRepository;
	
	public ConnectionController() {
		
	}
	
}
