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
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mellisphera.entities.AlertSent;
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
	
	@GetMapping("/apiary/hiveAllert/{idApiary}/{start}/{end}")
	public List<AlertSent> getHiveAlertByApiary(@PathVariable String idApiary, @PathVariable long start, @PathVariable long end) {
		Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.alertSentRepository.findByApiaryIdAndOpsDateBetween(idApiary, new Date(start), new Date(end), sort);
	}
	
	@PutMapping("/update/{id}")
	public AlertSent checkAlert(@PathVariable String id, @RequestBody Boolean check){
		AlertSent alertSent = this.alertSentRepository.findById(id).get();
		alertSent.setCheck(check);
		return this.alertSentRepository.save(alertSent);
	}

	@PutMapping("/check")
	public void checkNotif(@RequestBody List<AlertSent> checkAlert) {
		checkAlert.forEach(_notif -> {
			_notif.setCheck(true);
			this.alertSentRepository.save(_notif);
		});
	}
	@PostMapping("/between/hive/{idHive}")
	public List<AlertSent> getHiveAlert(@PathVariable String idHive, @RequestBody Date[] range) {
		Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.alertSentRepository.findByHiveIdAndOpsDateBetween(idHive, range[0], range[1], sort);
	}

	@PostMapping("/between/apiary/{idApiary}")
	public List<AlertSent> getApiaryAlert(@PathVariable String idApiary, @RequestBody Date[] range) {
		Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.alertSentRepository.findByApiaryIdAndOpsDateBetween(idApiary, range[0], range[1], sort).stream().filter(_alertSent -> _alertSent.getLoc().equals("Apiary")).collect(Collectors.toList());
	}

	@PostMapping("/filter/{apiaryId}")
	public List<AlertSent> getAlertsByFilters(@PathVariable String apiaryId, @RequestBody ObjectNode body){
		Sort sort = new Sort(Direction.DESC, "timestamp");
		List<String> hiveIds = new ObjectMapper().convertValue(body.get("hiveIds"), ArrayList.class);
		List<String> opsRange = new ObjectMapper().convertValue(body.get("opsRange"), ArrayList.class);
		List<String> pictos = new ObjectMapper().convertValue(body.get("pictos"), ArrayList.class);
		List<String> locations = new ObjectMapper().convertValue(body.get("loc"), ArrayList.class);
		
		Date start = Date.from( Instant.parse(opsRange.get(0)) );
        Date end = Date.from( Instant.parse(opsRange.get(1)) );

		return this.alertSentRepository.findByApiaryIdAndOpsDateBetween(apiaryId, start, end, sort)
                                        .stream()
                                        .filter(_alert -> hiveIds.contains(_alert.getHiveId()) || _alert.getHiveId() == null)
                                        .filter(_alert -> pictos.contains(_alert.getIcon()))
										.filter(_alert -> locations.contains(_alert.getLoc()))
                                        .collect(Collectors.toList());
	
	}

	@PostMapping("/delete")
	public void deleteAlertSent(@RequestBody String[] inspIds){
		List<String> ids = Arrays.asList(inspIds);
		this.alertSentRepository.deleteBy_idIn(ids);
	}

	private Date convertTimestampToDate(long time){
		return new Date(time*1000);
	}

}
