package com.mellisphera.controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.mellisphera.entities.DailyRecordsTH;
import com.mellisphera.entities.Hive;
import com.mellisphera.repositories.DailyRecordsTHRepository;
import com.mellisphera.repositories.HivesRepository;

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
        
    @RequestMapping(value = "/last/{idHive}" , method = RequestMethod.POST, produces={"application/json"})
    public List<DailyRecordsTH> getLastDailyRecord(@PathVariable String idHive, @RequestBody Date [] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        Date start  = range[0];
        Date end = range[1];
        System.err.println(start.toString());
        return this.dailyRecordsTHRepository.findByIdHiveAndRecordDateBetween(idHive, start, end, sort);
	}
	
	@RequestMapping(value = "/{username}/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
	public List<DailyRecordsTH> getByApiary(@PathVariable String username, @PathVariable String idApiary){
		List<Hive> hives = this.hiveController.getAllUserHives(idApiary);
		List<DailyRecordsTH> dailyRecTh = new ArrayList<>();
		Date start = new Date();
		start.setDate(new Date().getDate() - 1);
		start.setHours(0);
		start.setMinutes(0);
		for(Hive h : hives) {
                    System.err.println(h.getIdApiary());
                    try{
                    	List<DailyRecordsTH> rec = this.getLastDailyRecord(h.getId(), new Date[] {start, new Date()});
                    	System.err.println(rec);
                    	dailyRecTh.add(rec.get(rec.size() - 1));
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
