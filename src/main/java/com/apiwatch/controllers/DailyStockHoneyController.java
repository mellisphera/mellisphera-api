package com.apiwatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.apiwatch.entities.DailyStockHoney;

import com.apiwatch.repositories.DailyStockHoneyRepository;

import java.util.List;


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
    	
	    List<DailyStockHoney> dailyStockHoney=this.dailyStockHoneyRepository.findAll();
	    
	    return dailyStockHoney;
    }

}
