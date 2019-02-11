package com.apiwatch.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiwatch.entities.Connection;
import com.apiwatch.repositories.ConnectionRepository;
import com.apiwatch.security.entities.GeoIp;

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
