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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.mellisphera.entities.DailyStockHoney;
import com.mellisphera.repositories.DailyStockHoneyRepository;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;


@Service
@RestController
@RequestMapping("/dailyStockHoney")
public class DailyStockHoneyController {
	
	@Autowired
    private DailyStockHoneyRepository dailyStockHoneyRepository;

    public DailyStockHoneyController() {
    }

    public DailyStockHoneyController(DailyStockHoneyRepository dailyStockHoneyRepository) {
        this.dailyStockHoneyRepository = dailyStockHoneyRepository;
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<DailyStockHoney> getAll(){	
	    return this.dailyStockHoneyRepository.findAll();
    }
    
    @RequestMapping(value = "/apiary/{apiaryId}", method = RequestMethod.GET, produces={"application/json"})
    public List<DailyStockHoney> getByapiaryId(@PathVariable String apiaryId){
        return this.dailyStockHoneyRepository.findDailySrtockHoneyByApiaryId(apiaryId);
    }
    
       @RequestMapping(value = "/hive/{hiveId}", method = RequestMethod.GET, produces={"application/json"})
    public List<DailyStockHoney> getByhiveId(@PathVariable String hiveId, HttpServletResponse response){
        Sort sort = new Sort(Sort.Direction.DESC, "timestamp");	
        List<DailyStockHoney> stockByHive = this.dailyStockHoneyRepository.findDailyStockHoneyByHiveId(hiveId, sort);
        if(stockByHive.isEmpty()) {
        	response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return stockByHive;
    }

}
