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


	@RequestMapping(value="/hive/{hiveId}", method = RequestMethod.GET, produces={"application/json"})
	public List<DailyRecordsTH> getByhiveId(@PathVariable("hiveId") String hiveId){
		return this.dailyRecordsTHRepository.findDailyRecordsTHByHiveId(hiveId);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") String id) {
		this.dailyRecordsTHRepository.deleteById(id);
	}
        
    @RequestMapping(value = "/last/{hiveId}" , method = RequestMethod.POST, produces={"application/json"})
    public List<DailyRecordsTH> getLastDailyRecord(@PathVariable String hiveId, @RequestBody Date [] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        Date start  = range[0];
        Date end = range[1];
        return this.dailyRecordsTHRepository.findByHiveIdAndRecordDateBetween(hiveId, start, end, sort);
	}
	
	@RequestMapping(value = "/apiary/{idApiary}", method = RequestMethod.POST, produces={"application/json"})
	public List<DailyRecordsTH> getByApiary(@PathVariable String idApiary, @RequestBody Date[] range){
		List<Hive> hives = this.hiveController.getAllUserHives(idApiary);
		List<DailyRecordsTH> dailyRecTh = new ArrayList<>();
		for(Hive h : hives) {
                    try{
                    	List<DailyRecordsTH> rec = this.getLastDailyRecord(h.get_id(), range);
                    	dailyRecTh.add(rec.get(rec.size() - 1));
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                       // e.printStackTrace();
                    }
                    catch(IndexOutOfBoundsException err){
                        //err.printStackTrace();
                    }

		}
		
		return dailyRecTh;
	}
	
	@PostMapping("tMax/{hiveId}")
	public List<SimpleSeries> getTmaxByHive(@RequestBody Date[] range, @PathVariable String hiveId) {
		Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.dailyRecordsTHRepository.findByHiveIdAndRecordDateBetween(hiveId, range[0], range[1], sort).stream().map(_daily -> new SimpleSeries(_daily
				.getRecordDate(), _daily.getTemp_int_max(), _daily.getSensorRef())).collect(Collectors.toList());
	}
	@PostMapping("hInt/{hiveId}")
	public List<SimpleSeries> getHintByHive(@RequestBody Date[] range, @PathVariable String hiveId){
        Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.dailyRecordsTHRepository.findByHiveIdAndRecordDateBetween(hiveId, range[0], range[1], sort).stream().map(_daily -> new SimpleSeries(_daily
				.getRecordDate(), _daily.getHumidity_int_max(), _daily.getSensorRef())).collect(Collectors.toList());
	}
	
	@PostMapping("brood/{hiveId}")
	public List<SimpleSeries> getBroodByHive(@RequestBody Date[] range, @PathVariable String hiveId){
        Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.dailyRecordsTHRepository.findByHiveIdAndRecordDateBetween(hiveId, range[0], range[1], sort).stream().map(_daily -> new SimpleSeries(_daily
				.getRecordDate(), _daily.getBrood(), _daily.getSensorRef())).collect(Collectors.toList());
	}
	
	@PostMapping("tMin/{hiveId}")
	public List<SimpleSeries> getTMinByHive(@RequestBody Date[] range, @PathVariable String hiveId){
        Sort sort = new Sort(Direction.DESC, "timestamp");
		return this.dailyRecordsTHRepository.findByHiveIdAndRecordDateBetween(hiveId, range[0], range[1], sort).stream().map(_daily -> new SimpleSeries(_daily
				.getRecordDate(), _daily.getTemp_int_min(), _daily.getSensorRef())).collect(Collectors.toList());
	}
	
	

}
