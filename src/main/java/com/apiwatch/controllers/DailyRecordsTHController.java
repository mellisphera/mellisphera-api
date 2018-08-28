package com.apiwatch.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.apiwatch.entities.DailyRecordsTH;
import com.apiwatch.repositories.DailyRecordsTHRepository;

@Service
@RestController
@RequestMapping("/dailyRecordsTH")
@CrossOrigin(origins = {"http://localhost:4200", "http://***REMOVED***:4200","http://***REMOVED***:4300"})
public class DailyRecordsTHController {
	
	@Autowired
	private DailyRecordsTHRepository dailyRecordsTHRepository;
	
	public DailyRecordsTHController(DailyRecordsTHRepository dailyRecordsTHRepository) {
		this.dailyRecordsTHRepository = dailyRecordsTHRepository;
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET, produces={"application/json"})
	public List<DailyRecordsTH> getAll(){
		return this.dailyRecordsTHRepository.findAll();
	}
	
	@RequestMapping(value="/hive/{idHive}", method = RequestMethod.GET, produces={"application/json"})
	public List<DailyRecordsTH> getByIdHive(@PathVariable("idHive") String idHive){
		return this.dailyRecordsTHRepository.findDailyRecordsTHByIdHive(idHive);
	}
	

}
