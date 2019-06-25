package com.mellisphera.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	public List<List<Alert>> getByApiary(@PathVariable String idApiary) {
		List<Alert> allAlert = this.alertRepository.findByIdApiary(idApiary);
		List<Alert> checkAlert = allAlert.stream().filter(alert -> alert.getCheck()).collect(Collectors.toList());
		List<Alert> noCheckAlert = allAlert.stream().filter(alert -> !alert.getCheck()).collect(Collectors.toList());
		List<List<Alert>> resRequest = new ArrayList<List<Alert>>();
		resRequest.add(checkAlert);
		resRequest.add(noCheckAlert);
		return resRequest;
	}
	
	@GetMapping("/hive/{idHive}")
	public List<List<Alert>> getByHive(@PathVariable String idHive){
		List<Alert> allAlert = this.alertRepository.findByIdHive(idHive);
		List<Alert> checkAlert = allAlert.stream().filter(alert -> alert.getCheck()).collect(Collectors.toList());
		List<Alert> noCheckAlert = allAlert.stream().filter(alert -> !alert.getCheck()).collect(Collectors.toList());
		List<List<Alert>> resRequest = new ArrayList<List<Alert>>();
		resRequest.add(checkAlert);
		resRequest.add(noCheckAlert);
		return resRequest;
	}
	
	@PutMapping("/update/{id}")
	public Alert checkAlert(@PathVariable String id){
		Alert alert = this.alertRepository.findById(id).get();
		alert.setCheck(true);
		return this.alertRepository.save(alert);
	}

}
