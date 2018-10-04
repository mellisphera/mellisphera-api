package com.apiwatch.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apiwatch.entities.DailyRecordsTH;
import com.apiwatch.entities.DailyRecordsW;
import com.apiwatch.repositories.DailyRecordsWRepository;

@Service
@RestController
@RequestMapping("/dailyRecordsW")
public class DailyRecordsWController {

	@Autowired
	private DailyRecordsWRepository dailyRecordsWRepository;
	
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
		return this.dailyRecordsWRepository.findDailyRecordsWById(idHive);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") String id) {
		this.dailyRecordsWRepository.deleteById(id);
	}
}
