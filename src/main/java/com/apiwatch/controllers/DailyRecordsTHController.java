package com.apiwatch.controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.apiwatch.entities.DailyRecordsTH;
import com.apiwatch.entities.Hive;
import com.apiwatch.repositories.DailyRecordsTHRepository;
import com.apiwatch.repositories.HivesRepository;

@Service
@RestController
@RequestMapping("/dailyRecordsTH")
public class DailyRecordsTHController {


	@Autowired private HiveController hiveController;
	@Autowired private DailyRecordsTHRepository dailyRecordsTHRepository;
	@Autowired private HivesRepository hivesRepository;

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
        
	@RequestMapping(value="/last/hive/{idHive}", method = RequestMethod.GET, produces={"application/json"})
	public DailyRecordsTH getLast(@PathVariable("idHive") String idHive){
		List<DailyRecordsTH> dailyrec = this.dailyRecordsTHRepository.findDailyRecordsTHByIdHive(idHive);
                return dailyrec.get(dailyrec.size()-1);
	}
	
	@RequestMapping(value = "/{username}/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
	public List<DailyRecordsTH> getByApiary(@PathVariable String username, @PathVariable String idApiary){
		this.hiveController = new HiveController(hivesRepository);
		List<Hive> hives = this.hiveController.getAllUserHives(username, idApiary);
		List<DailyRecordsTH> dailyRecTh = new ArrayList<>();
		for(Hive h : hives) {
                    System.err.println(h.getIdApiary());
                    try{
                    	dailyRecTh.add(this.getLast(h.getId()));		
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.err.println(e.getMessage());
                    }
                    catch(IndexOutOfBoundsException e){
                        System.err.println(e.getMessage());
                    }

		}
		
		return dailyRecTh;
	}

}
