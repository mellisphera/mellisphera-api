package com.mellisphera.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.DailyRecordsTH;
import com.mellisphera.entities.DailyRecordsW;
import com.mellisphera.entities.Hive;
import com.mellisphera.entities.SimpleSeries;
import com.mellisphera.repositories.DailyRecordsWRepository;

@Service
@RestController
@RequestMapping("/dailyRecordsW")
public class DailyRecordsWController {

	@Autowired
	private DailyRecordsWRepository dailyRecordsWRepository;
	@Autowired HiveController hiveController;
	
	public DailyRecordsWController(DailyRecordsWRepository dailyRecordsWRepository) {
		this.dailyRecordsWRepository = dailyRecordsWRepository;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
	public List<DailyRecordsW> getAll(){
		return this.dailyRecordsWRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces={"application/json"})
	public Optional<DailyRecordsW> getById(@PathVariable("id") String id){
		return this.dailyRecordsWRepository.findById(id);
	}
	
	@RequestMapping(value="/hive/{idHive}", method = RequestMethod.GET, produces={"application/json"})
	public List<DailyRecordsW>getByidHive(@PathVariable("idHive") String idHive){
		return this.dailyRecordsWRepository.findDailyRecordsWByIdHive(idHive);
	}
	
	@PostMapping("/apiary/{idApiary}")
	public List<List<DailyRecordsW>> getDailyRecordsWByApiary(@PathVariable String idApiary, @RequestBody Date[] range) {
        Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.hiveController.getAllUserHives(idApiary).stream().map(hive -> this.dailyRecordsWRepository.findByIdHiveAndRecordDateBetween(hive.getId(), range[0], range[1], sort)).collect(Collectors.toList());
	}
	
	@PostMapping("tMin/{idHive}")
	public List<SimpleSeries> getTminByHive(@RequestBody Date[] range, @PathVariable String idHive){
        Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.dailyRecordsWRepository.findByIdHiveAndRecordDateBetween(idHive, range[0], range[1], sort).stream().map(_daily -> new SimpleSeries(_daily
				.getRecordDate(), _daily.getTemp_ext_min())).collect(Collectors.toList());
	}
	
	@PostMapping("tMax/{idHive}")
	public List<SimpleSeries> getTmaxByHive(@RequestBody Date[] range, @PathVariable String idHive){
        Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.dailyRecordsWRepository.findByIdHiveAndRecordDateBetween(idHive, range[0], range[1], sort).stream().map(_daily -> new SimpleSeries(_daily
				.getRecordDate(), _daily.getTemp_ext_max())).collect(Collectors.toList());
	}
	
	@PostMapping("weightMax/{idHive}")
	public List<SimpleSeries> getTmaxByHive(@RequestBody Date[] range, @PathVariable String idHive){
        Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.dailyRecordsWRepository.findByIdHiveAndRecordDateBetween(idHive, range[0], range[1], sort).stream().map(_daily -> new SimpleSeries(_daily
				.getRecordDate(), _daily.getWeight_max())).collect(Collectors.toList());
	}
	
}
