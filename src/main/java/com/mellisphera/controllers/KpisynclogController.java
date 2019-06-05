package com.mellisphera.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.Kpisynclog;
import com.mellisphera.repositories.KpisynclogRepository;

@RestController
@RequestMapping("/kpisynclog")
@PreAuthorize("hasRole('ADMIN')") 
public class KpisynclogController {
	
	@Autowired private KpisynclogRepository kpisynclogRepository;
	public KpisynclogController() {}
	
	@GetMapping("/all")
	public List<Kpisynclog> getAll() {
		return this.kpisynclogRepository.findAll();
	}
	
	@PostMapping("/between")
	public List<Kpisynclog> getByRange(@RequestBody Date start) {
		return this.kpisynclogRepository.findByDateBetween(start, new Date());
		
	}
	
	
	
	

}
