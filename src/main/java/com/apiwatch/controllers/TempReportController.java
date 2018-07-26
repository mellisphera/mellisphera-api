package com.apiwatch.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apiwatch.entities.SoldDevice;
import com.apiwatch.entities.TempReport;
import com.apiwatch.repositories.TempReportRepository;

@RestController
@RequestMapping("/report")
@CrossOrigin(origins = {"http://localhost:4200", "http://***REMOVED***:4200","http://***REMOVED***:4300"})
public class TempReportController {
	
	
	@Autowired
    private TempReportRepository TempReportRepository;
	
    public TempReportController() {
	    }

    public TempReportController(TempReportRepository TempReportRepository) {
	        this.TempReportRepository = TempReportRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    @GetMapping("/ruche/{idApiary}")
    public Map<String, List<TempReport>> getObservationRuche(@PathVariable("idApiary") String idApiary){
    List<TempReport> tempReports=this.TempReportRepository.findAll();
    List<TempReport> observationsNature= new ArrayList<>();
    List<String> observations= new ArrayList<>();
    Map<String, List<TempReport>> map = new HashMap<>();
    
    
    for(TempReport tr : tempReports) {
    	if(tr.getType() != null) {
    	if(tr.getType().equals("ObservationRuche") && tr.getIdApiary().equals(idApiary)) {
    		observationsNature.add(tr);
    		observations.add(tr.getSentence());
    		}
    	}
    }
    
    map.put("ObservationRuche",observationsNature);
   
    return map;
    }
    
    @GetMapping("/nature/{idApiary}")
    public Map<String, List<TempReport>> getObservationsNature(@PathVariable("idApiary") String idApiary){
    List<TempReport> tempReports=this.TempReportRepository.findAll();
    List<TempReport> observationsNature= new ArrayList<>();
    List<String> observations= new ArrayList<>();
    Map<String, List<TempReport>> map = new HashMap<>();
    
    
    for(TempReport tr : tempReports) {
    	if(tr.getType() != null) {
    	if(tr.getType().equals("ObservationNature") && tr.getIdApiary().equals(idApiary)) {
    		observationsNature.add(tr);
    		observations.add(tr.getSentence());
    		}
    	}
    }
    
    map.put("ObservationNature",observationsNature);
   
    return map;
    }

    
    
    @GetMapping("/apicole/{idApiary}")
    public Map<String, List<TempReport>> getActionApicole(@PathVariable("idApiary") String idApiary){
    List<TempReport> tempReports=this.TempReportRepository.findAll();
    List<TempReport> observationsNature= new ArrayList<>();
    List<String> observations= new ArrayList<>();
    Map<String, List<TempReport>> map = new HashMap<>();
    
    
    for(TempReport tr : tempReports) {
    	if(tr.getType() != null) {
    	if(tr.getType().equals("ActionApi") && tr.getIdApiary().equals(idApiary)) {
    		observationsNature.add(tr);
    		observations.add(tr.getSentence());
    		}
    	}
    }
    
    map.put("ActionApi",observationsNature);
   
    return map;
    }
    /*
    @GetMapping("/ruche1/{idApiary}")
    public Map<String, Map<String,String>> getObservationRuches(@PathVariable("idApiary") String idApiary){
    List<TempReport> tempReports=this.TempReportRepository.findAll();
    List<TempReport> observationsNature= new ArrayList<>();
    List<String> observations= new ArrayList<>();
    
    Map<String, List<TempReport>> map = new HashMap<>();
    
    
    for(TempReport tr : tempReports) {
    	if(tr.getType() != null) {
    	if(tr.getType().equals("ObservationRuche") && tr.getIdApiary().equals(idApiary)) {
    		observationsNature.add(tr);
    		observations.add(tr.getSentence());
    		}
    	}
    }
    
    map.put("ObservationRuche",observationsNature);
   
    return map;
    }*/
}
