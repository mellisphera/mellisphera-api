package com.mellisphera.controllers;

import java.sql.Array;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

import com.mellisphera.entities.ProcessReport;
import com.mellisphera.repositories.ProcessReportRepository;

@Service
@RestController
@RequestMapping("/report")
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
    public ProcessReport insert(@RequestBody ProcessReport observation){
        return this.processReportRepository.insert(observation);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ProcessReport> getAll(){
        return this.processReportRepository.findAll();
    }
    
    @RequestMapping(value = "/apiary/{idApiary}", method = RequestMethod.POST, produces={"application/json"})
    public List<ProcessReport> getReportsApiray(@PathVariable("idApiary") String idApiary, @RequestBody Date[] range){
        List<ProcessReport> reports = this.processReportRepository.findByIdApiaryAndDateBetween(idApiary, range[0], range[1]);
        Collections.reverse(reports);
        return reports;
    }
    
    @RequestMapping(value = "/hive/{idHive}", method = RequestMethod.POST, produces={"application/json"})
    public List<ProcessReport> getReportsHive(@PathVariable("idHive") String idHive, @RequestBody Date[] range){
        Date start  = range[0];
        Date end = range[1];
        System.err.println(start + "---" + end);
        List<ProcessReport> reportsL = this.processReportRepository.findByIdHiveAndDateBetween(idHive, start, new Date());
        System.err.println(reportsL);
        Collections.reverse(reportsL);
        return reportsL;
    }
    
    @DeleteMapping("/{id}")
	 public void delete(@PathVariable("id") String id){
	    this.processReportRepository.deleteById(id);
	 }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody ProcessReport processReport){   
    	
    	ProcessReport report= this.processReportRepository.findProcessReportById(id);
    	
    	report.setDate((Date)processReport.getDate());
    	report.setType(processReport.getType());
    	report.setSentence(processReport.getSentence());
    	report.setId(processReport.getId());
    	report.setIdApiary(processReport.getIdApiary());
    	report.setIdHive(processReport.getIdHive());
    	report.setIdLHive(processReport.getIdLHive());
    	report.setNluScore(processReport.getNluScore());
    	
 		this.processReportRepository.save(report);
    }
   
	
}
