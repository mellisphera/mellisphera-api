package com.apiwatch.controllers;


import java.util.Date;
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
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") String id) {
		this.dailyRecordsTHRepository.deleteById(id);
	}
	/*
	@RequestMapping(value="/last/{idHive}", method = RequestMethod.GET, produces={"application/json"})
	public List<DailyRecordsTH> getByLastDate(@PathVariable("idHive") String idHive) {
		List<DailyRecordsTH> dailyRecords = this.dailyRecordsTHRepository.findDailyRecordsTHByrecordDate(new Date());
		return dailyRecords;
	}*/
	
	@RequestMapping(value="/last/{idHive}", method = RequestMethod.GET, produces={"application/json"})
	public DailyRecordsTH getByLastDate(@PathVariable("idHive") String idHive) {
		List<DailyRecordsTH> dailyRecTh = this.dailyRecordsTHRepository.findDailyRecordsTHByIdHive(idHive);
		for(DailyRecordsTH d : dailyRecTh) {
			if(new Date().getDate() == d.getRecordDate().getDate()) {
				return d;
			}
		}
		return null;
	}
	
}
