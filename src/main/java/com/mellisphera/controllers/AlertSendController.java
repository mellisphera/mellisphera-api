package com.mellisphera.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mellisphera.entities.AlertSent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.repositories.AlertSendRepository;

@Service
@RestController
@RequestMapping("/alertSend")
public class AlertSendController {
	
	static final private String NOTIF = "NOTIF";
	@Autowired private AlertSendRepository alertSendRepository;
	
	@GetMapping("/apiary/{idApiary}")
	public List<AlertSent> getByApiary(@PathVariable String idApiary) {
		return this.alertSendRepository.findByIdApiary(idApiary).stream().filter(_alertSent -> _alertSent.getLoc().equals("Apiary")).collect(Collectors.toList());

	}
	
	@GetMapping("/hive/{idHive}")
	public List<AlertSent> getByHive(@PathVariable String idHive){
		return this.alertSendRepository.findByIdHive(idHive).stream().filter(_alertSent -> _alertSent.getLoc().equals("Hive")).collect(Collectors.toList());
	}
	
	@GetMapping("/apiary/hiveAllert/{idApiary}")
	public List<AlertSent> getHiveAlertByApiary(@PathVariable String idApiary) {
		return this.alertSendRepository.findByIdApiary(idApiary).stream().filter(_alertSent -> _alertSent.getLoc().equals("Hive")).collect(Collectors.toList());
	}
	
	@PutMapping("/update/{id}")
	public AlertSent checkAlert(@PathVariable String id, @RequestBody Boolean check){
		AlertSent alertSent = this.alertSendRepository.findById(id).get();
		alertSent.setCheck(check);
		return this.alertSendRepository.save(alertSent);
	}
	
	@PostMapping("/between/hive/{idHive}")
	public List<AlertSent> getHiveAlert(@PathVariable String idHive, @RequestBody Date[] range) {
		return this.alertSendRepository.findByIdHiveAndDateBetween(idHive, range[0], range[1]).stream().filter(_alertSent -> _alertSent.getLoc().equals("Hive")).collect(Collectors.toList());
	}

}
