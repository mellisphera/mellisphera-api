package com.apiwatch.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apiwatch.entities.SoldDevice;
import com.apiwatch.entities.User;
import com.apiwatch.entities.ProcessReportTemp;
import com.apiwatch.repositories.TempReportRepository;
import com.apiwatch.weather.HourlyWeather;

@RestController
@RequestMapping("/report-temp")
@CrossOrigin(origins = {"http://localhost:4200", "http://51.68.71.91:4200","http://51.68.71.91:4300"})
public class TempReportController {
	
	
	@Autowired
    private TempReportRepository tempReportRepository;
	
    public TempReportController() {
	    }

    public TempReportController(TempReportRepository tempReportRepository) {
	        this.tempReportRepository = tempReportRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    @GetMapping("/ruche/{idApiary}")
    public Map<String, List<ProcessReportTemp>> getObservationRuche(@PathVariable("idApiary") String idApiary){
    List<ProcessReportTemp> tempReports=this.tempReportRepository.findAll();
    List<ProcessReportTemp> observationsNature= new ArrayList<>();
    List<String> observations= new ArrayList<>();
    Map<String, List<ProcessReportTemp>> map = new HashMap<>();
    
    
    for(ProcessReportTemp tr : tempReports) {
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
    public Map<String, List<ProcessReportTemp>> getObservationsNature(@PathVariable("idApiary") String idApiary){
    List<ProcessReportTemp> tempReports=this.tempReportRepository.findAll();
    List<ProcessReportTemp> observationsNature= new ArrayList<>();
    List<String> observations= new ArrayList<>();
    Map<String, List<ProcessReportTemp>> map = new HashMap<>();
    
    
    for(ProcessReportTemp tr : tempReports) {
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
    public Map<String, List<ProcessReportTemp>> getActionApicole(@PathVariable("idApiary") String idApiary){
    List<ProcessReportTemp> tempReports=this.tempReportRepository.findAll();
    List<ProcessReportTemp> observationsNature= new ArrayList<>();
    List<String> observations= new ArrayList<>();
    Map<String, List<ProcessReportTemp>> map = new HashMap<>();
    
    
    for(ProcessReportTemp tr : tempReports) {
    	if(tr.getType() != null) {
    	if(tr.getType().equals("OperationApi") && tr.getIdApiary().equals(idApiary)) {
    		observationsNature.add(tr);
    		observations.add(tr.getSentence());
    		}
    	}
    }
    
    map.put("OperationApi",observationsNature);
   
    return map;
    }

    @GetMapping("/apicole-ruche/{nomRuche}")
    public Map<String, List<ProcessReportTemp>> getActionApicoleRuche(@PathVariable("nomRuche") String nomRuche){
        
    	List<ProcessReportTemp> tempReports=this.tempReportRepository.findAll();
        List<ProcessReportTemp> observationsRuche= new ArrayList<>();
        List<String> observations= new ArrayList<>();
        Map<String, List<ProcessReportTemp>> map = new HashMap<>();
        
        for(ProcessReportTemp tr : tempReports) {
        	if(tr.getType() != null && tr.getRuche()!=null) {
        	if(tr.getType().equals("OperationApi") && tr.getRuche().contains(nomRuche)) {
        		
        		observationsRuche.add(tr);
        		observations.add(tr.getSentence());
        		}
        	}
        }
        
        map.put("OperationApi",observationsRuche);
       
        return map;
    }
    
    @GetMapping("/observations-ruche/{nomRuche}")
    public Map<String, List<ProcessReportTemp>> getObservationRuchePerName(@PathVariable("nomRuche") String nomRuche){
    
    	List<ProcessReportTemp> tempReports=this.tempReportRepository.findAll();
    	List<ProcessReportTemp> observationsRuche= new ArrayList<>();
    	List<String> observations= new ArrayList<>();
    	Map<String, List<ProcessReportTemp>> map = new HashMap<>();
    
	    for(ProcessReportTemp tr : tempReports) {
	    	if(tr.getType() != null && tr.getRuche()!=null) {
	    	if(tr.getType().equals("ObservationRuche") && tr.getRuche().contains(nomRuche)) {
	    		observationsRuche.add(tr);
	    		observations.add(tr.getSentence());
	    		}
	    	}
	    }
	    
	    map.put("ObservationRuche",observationsRuche);
	   
	    return map;
    }
    
    //for delete everytime the page report launches
    @DeleteMapping(value="/deleteAll")
    public void deleteAll(){    
    	this.tempReportRepository.deleteAll();
    }

}
