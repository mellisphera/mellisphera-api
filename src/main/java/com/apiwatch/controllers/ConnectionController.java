package com.apiwatch.controllers;

import com.apiwatch.repositories.ConnectionRepository;

public class ConnectionController{
	
	private ConnectionRepository connectionRepository;
	
	public ConnectionController() {
		
	}
	
	public ConnectionController(ConnectionRepository connectionRepository) {
		this.connectionRepository = connectionRepository;
	}
}
