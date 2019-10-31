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

import com.mellisphera.repositories.AlertSentRepository;

@Service
@RestController
@RequestMapping("/alertSend")
public class AlertSentController {
	
	static final private String NOTIF = "NOTIF";
	@Autowired private AlertSentRepository alertSentRepository;
	
	@GetMapping("/apiary/{idApiary}")
	public List<AlertSent> getByApiary(@PathVariable String idApiary) {
		return this.alertSentRepository.findByApiaryId(idApiary).stream().filter(_alertSent -> _alertSent.getLoc().equals("Apiary")).collect(Collectors.toList());

	}
	
	@GetMapping("/hive/{idHive}")
	public List<AlertSent> getByHive(@PathVariable String idHive){
		return this.alertSentRepository.findByHiveId(idHive).stream().filter(_alertSent -> _alertSent.getLoc().equals("Hive")).collect(Collectors.toList());
	}
	
	@GetMapping("/apiary/hiveAllert/{idApiary}")
	public List<AlertSent> getHiveAlertByApiary(@PathVariable String idApiary) {
		return this.alertSentRepository.findByApiaryId(idApiary).stream().filter(_alertSent -> _alertSent.getLoc().equals("Hive")).collect(Collectors.toList());
	}
	
	@PutMapping("/update/{id}")
	public AlertSent checkAlert(@PathVariable String id, @RequestBody Boolean check){
		AlertSent alertSent = this.alertSentRepository.findById(id).get();
		alertSent.setCheck(check);
		return this.alertSentRepository.save(alertSent);
	}
	
	@PostMapping("/between/hive/{idHive}")
	public List<AlertSent> getHiveAlert(@PathVariable String idHive, @RequestBody Date[] range) {
		return this.alertSentRepository.findByHiveIdAndOpsDateBetween(idHive, range[0], range[1]).stream().filter(_alertSent -> _alertSent.getLoc().equals("Hive")).collect(Collectors.toList());
	}

	@PostMapping("/between/apiary/{idApiary}")
	public List<AlertSent> getApiaryAlert(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.alertSentRepository.findByApiaryIdAndOpsDateBetween(idApiary, range[0], range[1]).stream().filter(_alertSent -> _alertSent.getLoc().equals("Apiary")).collect(Collectors.toList());
	}

}
