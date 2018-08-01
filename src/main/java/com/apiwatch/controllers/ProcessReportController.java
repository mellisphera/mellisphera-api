package com.apiwatch.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiwatch.entities.ProcessReport;
import com.apiwatch.repositories.ProcessReportRepository;



@RestController
@RequestMapping("/report")
@CrossOrigin(origins = {"http://localhost:4200", "http://51.68.71.91:4200","http://51.68.71.91:4300"})
public class ProcessReportController {

	@Autowired
    private ProcessReportRepository ProcessReportRepository;
	
    public ProcessReportController() {
	    }

    public ProcessReportController(ProcessReportRepository ProcessReportRepository) {
	        this.ProcessReportRepository = ProcessReportRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    @GetMapping("/ruche/{idApiary}")
    public Map<String, List<ProcessReport>> getObservationRuche(@PathVariable("idApiary") String idApiary){
    List<ProcessReport> tempReports=this.ProcessReportRepository.findAll();
    List<ProcessReport> observationsNature= new ArrayList<>();
    List<String> observations= new ArrayList<>();
    Map<String, List<ProcessReport>> map = new HashMap<>();
    
    
    for(ProcessReport tr : tempReports) {
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
    public Map<String, List<ProcessReport>> getObservationsNature(@PathVariable("idApiary") String idApiary){
    List<ProcessReport> tempReports=this.ProcessReportRepository.findAll();
    List<ProcessReport> observationsNature= new ArrayList<>();
    List<String> observations= new ArrayList<>();
    Map<String, List<ProcessReport>> map = new HashMap<>();
    
    
    for(ProcessReport tr : tempReports) {
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
    public Map<String, List<ProcessReport>> getActionApicole(@PathVariable("idApiary") String idApiary){
    List<ProcessReport> tempReports=this.ProcessReportRepository.findAll();
    List<ProcessReport> observationsNature= new ArrayList<>();
    List<String> observations= new ArrayList<>();
    Map<String, List<ProcessReport>> map = new HashMap<>();
    
    
    for(ProcessReport tr : tempReports) {
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
    public Map<String, List<ProcessReport>> getActionApicoleRuche(@PathVariable("nomRuche") String nomRuche){
        List<ProcessReport> tempReports=this.ProcessReportRepository.findAll();
        
        List<ProcessReport> observationsRuche= new ArrayList<>();
        List<String> observations= new ArrayList<>();
        Map<String, List<ProcessReport>> map = new HashMap<>();
        
        
        for(ProcessReport tr : tempReports) {
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
    public Map<String, List<ProcessReport>> getObservationRuchePerName(@PathVariable("nomRuche") String nomRuche){
    List<ProcessReport> tempReports=this.ProcessReportRepository.findAll();
   
    List<ProcessReport> observationsRuche= new ArrayList<>();
    List<String> observations= new ArrayList<>();
    Map<String, List<ProcessReport>> map = new HashMap<>();
    
    
    for(ProcessReport tr : tempReports) {
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
	
	
	
}
