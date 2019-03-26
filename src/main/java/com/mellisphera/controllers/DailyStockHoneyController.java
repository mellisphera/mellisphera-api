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
    
    @RequestMapping(value = "/apiary/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public List<DailyStockHoney> getByIdApiary(@PathVariable String idApiary){
        return this.dailyStockHoneyRepository.findDailySrtockHoneyByIdApiary(idApiary);
    }
    
       @RequestMapping(value = "/hive/{idHive}", method = RequestMethod.GET, produces={"application/json"})
    public List<DailyStockHoney> getByIdHive(@PathVariable String idHive, HttpServletResponse response){
        Sort sort = new Sort(Sort.Direction.DESC, "timestamp");	
        List<DailyStockHoney> stockByHive = this.dailyStockHoneyRepository.findDailyStockHoneyByIdHive(idHive, sort);
        if(stockByHive.isEmpty()) {
        	System.err.println("EMPTY");
        	response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return stockByHive;
    }

}
