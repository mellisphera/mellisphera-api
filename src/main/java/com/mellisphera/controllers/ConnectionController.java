package com.mellisphera.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	private final static String[] USER_EXCLU = {"lpo", "admin", "mickael", "demo"};
	@Autowired
	private ConnectionRepository connectionRepository;
	
	
	@GetMapping("")
	public List<Connection> getAll(){
		return this.connectionRepository.findAll();
	}
	
	@PostMapping("/between")
	public List<Connection> getConnectionBetween(@RequestBody Date start){
		return this.connectionRepository.findByconnectionDateBetween(start, new Date()).stream().filter(_connection -> Arrays.asList(USER_EXCLU).indexOf(_connection.getUsername()) != -1).collect(Collectors.toList());
	}
	
}
