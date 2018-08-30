package com.apiwatch.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apiwatch.entities.ProcessReportTemp;
import com.apiwatch.repositories.ProcessReportTempRepository;

@Service
@RestController
@RequestMapping("/report_temp")
@CrossOrigin(origins = {"http://localhost:4200", "http://***REMOVED***:4200","http://***REMOVED***:4300"})
public class ProcessReportTempController {
	
	@Autowired
    private ProcessReportTempRepository processReportTempRepository;
	
    public ProcessReportTempController() {
	    }
    
    public ProcessReportTempController(ProcessReportTempRepository ProcessReportTempRepository) {
        this.processReportTempRepository = ProcessReportTempRepository;
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<ProcessReportTemp> getReportsApiray(@PathVariable("username") String username){
        List<ProcessReportTemp> reports = this.processReportTempRepository.findProcessReportTempByUsername(username);
        Collections.reverse(reports);
        return reports;
    }

}
