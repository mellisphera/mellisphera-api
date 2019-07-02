package com.mellisphera.controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.mellisphera.entities.DailyRecordsTH;
import com.mellisphera.entities.Hive;
import com.mellisphera.entities.SimpleSeries;
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
        System.err.println(end);
        return this.dailyRecordsTHRepository.findByIdHiveAndRecordDateBetween(idHive, start, end, sort);
	}
	
	@RequestMapping(value = "/apiary/{idApiary}", method = RequestMethod.POST, produces={"application/json"})
	public List<DailyRecordsTH> getByApiary(@PathVariable String idApiary, @RequestBody Date range){
		List<Hive> hives = this.hiveController.getAllUserHives(idApiary);
		List<DailyRecordsTH> dailyRecTh = new ArrayList<>();
		System.err.println(range);
		Date start = range;
		Date end = new Date();
		end.setDate(start.getDate() + 1);
		for(Hive h : hives) {
                    try{
                    	List<DailyRecordsTH> rec = this.getLastDailyRecord(h.getId(), new Date[] {start, end});
                    	System.err.println(rec.get(rec.size() - 1));
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
	
	@PostMapping("tMax/{idHive}")
	public List<SimpleSeries> getTmaxByHive(@RequestBody Date[] range, @PathVariable String idHive){
        Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.dailyRecordsTHRepository.findByIdHiveAndRecordDateBetween(idHive, range[0], range[1], sort).stream().map(_daily -> new SimpleSeries(_daily
				.getRecordDate(), _daily.getTemp_int_max())).collect(Collectors.toList());
	}
	
	@PostMapping("hInt/{idHive}")
	public List<SimpleSeries> getHintByHive(@RequestBody Date[] range, @PathVariable String idHive){
        Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.dailyRecordsTHRepository.findByIdHiveAndRecordDateBetween(idHive, range[0], range[1], sort).stream().map(_daily -> new SimpleSeries(_daily
				.getRecordDate(), _daily.getHumidity_int_max())).collect(Collectors.toList());
	} 

}
