package com.apiwatch.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apiwatch.entities.Apiary;
import com.apiwatch.entities.ProcessReport;
import com.apiwatch.repositories.ProcessReportRepository;

@Service
@RestController
@RequestMapping("/report")
@CrossOrigin(origins = {"http://localhost:4200", "http://***REMOVED***:4200","http://***REMOVED***:4300"})
public class ProcessReportController {

	@Autowired
    private ProcessReportRepository processReportRepository;
	
    public ProcessReportController() {
	    }

    public ProcessReportController(ProcessReportRepository processReportRepository) {
	        this.processReportRepository = processReportRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public void insert(@RequestBody ProcessReport observation){
        this.processReportRepository.insert(observation);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ProcessReport> getAll(){
        List<ProcessReport> reports = this.processReportRepository.findAll();
        return reports;
    }
    
    @RequestMapping(value = "/apiary/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public List<ProcessReport> getReportsApiray(@PathVariable("idApiary") String idApiary){
        List<ProcessReport> reports = this.processReportRepository.findProcessReportByIdApiary(idApiary);
        Collections.reverse(reports);
        return reports;
    }
    
    @RequestMapping(value = "/hive/{idHive}", method = RequestMethod.GET, produces={"application/json"})
    public List<ProcessReport> getReportsHive(@PathVariable("idHive") String idHive){
        List<ProcessReport> reports = this.processReportRepository.findProcessReportByIdHive(idHive);
        Collections.reverse(reports);
        return reports;
    }
    
    @DeleteMapping("/{id}")
	 public void delete(@PathVariable("id") String id){
	    this.processReportRepository.deleteById(id);
	 }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody ProcessReport processReport){   
    	
    	ProcessReport report= this.processReportRepository.findProcessReportById(id);
    	
    	report.setDate(processReport.getDate());
    	report.setType(processReport.getType());
    	report.setSentence(processReport.getSentence());
    	report.setId(processReport.getId());
    	report.setIdApiary(processReport.getIdApiary());
    	report.setIdHive(processReport.getIdHive());
    	report.setNluScore(processReport.getNluScore());
    	
 		this.processReportRepository.save(report);
    }
   
	
}
