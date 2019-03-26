package com.mellisphera.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.Connection;
import com.mellisphera.repositories.ConnectionRepository;
import com.mellisphera.security.entities.GeoIp;

@Service
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/logs")
public class ConnectionController{
	
	@Autowired
	private ConnectionRepository connectionRepository;
	
	
	@GetMapping("")
	public List<Connection> getAll(){
		return this.connectionRepository.findAll();
	}
	
}
