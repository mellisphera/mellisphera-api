package com.apiwatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.apiwatch.entities.DailyStockHoney;

import com.apiwatch.repositories.DailyStockHoneyRepository;

import java.util.List;
import org.springframework.data.domain.Sort;


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
    
    @RequestMapping(value = "/apiary/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public List<DailyStockHoney> getByIdApiary(@PathVariable String idApiary){
        return this.dailyStockHoneyRepository.findDailySrtockHoneyByIdApiary(idApiary);
    }
    
       @RequestMapping(value = "/hive/{idHive}", method = RequestMethod.GET, produces={"application/json"})
    public List<DailyStockHoney> getByIdHive(@PathVariable String idHive){
        Sort sort = new Sort(Sort.Direction.DESC, "timestamp");
        return this.dailyStockHoneyRepository.findDailyStockHoneyByIdHive(idHive,sort);
    }

}
