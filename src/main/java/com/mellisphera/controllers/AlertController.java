package com.mellisphera.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.Alert;
import com.mellisphera.repositories.AlertRepository;

@Service
@RestController
@RequestMapping("/alert")
public class AlertController {
	
	@Autowired private AlertRepository alertRepository;
	
	@GetMapping("/apiary/{idApiary}")
	public List<Alert> getByApiary(@PathVariable String idApiary) {
		return this.alertRepository.findByIdApiary(idApiary);
	}
	
	@GetMapping("/hive/{idHive}")
	public List<Alert> getByHive(@PathVariable String idHive){
		return this.alertRepository.findByIdHive(idHive);
	}
	
	@PutMapping("/update/{id}")
	public Alert checkAlert(@PathVariable String id){
		Alert alert = this.alertRepository.findById(id).get();
		alert.setCheck(true);
		return this.alertRepository.save(alert);
	}

}
