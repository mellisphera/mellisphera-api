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



package com.mellisphera.controllers;

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
	
	private final static String[] IP_EXCLU = {"83.193.59.211"};
	@Autowired
	private ConnectionRepository connectionRepository;
	
	
	@GetMapping("")
	public List<Connection> getAll(){
		return this.connectionRepository.findAll();
	}
	
	@PostMapping("/between")
	public List<Connection> getConnectionBetween(@RequestBody Date start){
		return this.connectionRepository.findByconnectionDateBetween(start, new Date()).stream().filter(_connection -> Arrays.asList(IP_EXCLU).indexOf(_connection.getUsername()) == -1).collect(Collectors.toList());
	}
	
}
