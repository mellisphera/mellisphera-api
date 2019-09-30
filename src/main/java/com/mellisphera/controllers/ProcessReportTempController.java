package com.mellisphera.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.ProcessReportTemp;
import com.mellisphera.repositories.NoteRepository;
import com.mellisphera.repositories.ProcessReportTempRepository;

@Service
@RestController
@RequestMapping("/report_temp")
public class ProcessReportTempController {
	
	@Autowired
    private ProcessReportTempRepository processReportTempRepository;
	@Autowired
    private NoteRepository noteRepository;
	
    public ProcessReportTempController() {
	    }
 
    
    
    public ProcessReportTempController(ProcessReportTempRepository ProcessReportTempRepository) {
        this.processReportTempRepository = ProcessReportTempRepository;
    }
    
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<ProcessReportTemp> getReports(@PathVariable("username") String username){
        List<ProcessReportTemp> reports = this.processReportTempRepository.findProcessReportTempByUsername(username);
        Collections.reverse(reports);
        return reports;
    }

    @DeleteMapping("/delete/{id}")
	 public void delete(@PathVariable("id") String id){
	    this.processReportTempRepository.deleteById(id);
	 }
    
    /*@RequestMapping(value = "/add/{username}", method = RequestMethod.GET, produces={"application/json"})
    public void addReports(@PathVariable("username") String username){
        List<ProcessReportTemp> reports = this.processReportTempRepository.findProcessReportTempByUsername(username);
        for(ProcessReportTemp temp : reports) {
        	ProcessReport process = new ProcessReport();
        	process.setDate(temp.getDate());
        	process.setIdApiary(temp.getIdApiary());
        	process.setIdHive(temp.getIdHive());
        	process.setIdLHive(temp.getIdLHive());
        	process.setNluScore(temp.getNluScore());
        	process.setSentence(temp.getSentence());
        	process.setUsername(temp.getUsername());
        	process.setType(temp.getType());
        	this.noteRepository.insert(process);
                this.delete(temp.getId());
        }
    }*/
    
}
