package com.mellisphera.controllers;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.mellisphera.entities.Note;
import com.mellisphera.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/report")
public class NoteController {

	@Autowired
    private NoteRepository noteRepository;
	
    public NoteController() {
	    }

    public NoteController(NoteRepository noteRepository) {
	        this.noteRepository = noteRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    
    
    @RequestMapping(value = "/insert", method = RequestMethod.PUT)
    public Note insert(@RequestBody Note observation){
        return this.noteRepository.insert(observation);
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Note> getAll(){
        return this.noteRepository.findAll();
    }
    
    @RequestMapping(value = "/apiary/{idApiary}", method = RequestMethod.POST, produces={"application/json"})
    public List<Note> getReportsApiray(@PathVariable("idApiary") String idApiary, @RequestBody Timestamp[] range){
        List<Note> reports = this.noteRepository.findByApiaryIdAndOpsDateBetween(idApiary, range[0], range[1]);
        Collections.reverse(reports);
        return reports;
    }
    
    @GetMapping("/user/{userId}")
    public List<Note> getReportsByUser(@PathVariable String userId) {
    	return this.noteRepository.findByUserId(userId);
    }
    
    @RequestMapping(value = "/hive/{idHive}", method = RequestMethod.POST, produces={"application/json"})
    public List<Note> getReportsHive(@PathVariable("idHive") String idHive, @RequestBody Date[] range){
        List<Note> reportsL = this.noteRepository.findByHiveIdAndOpsDateBetween(idHive, range[0], range[1]);
        return reportsL;
    }
    
    @DeleteMapping("/{id}")
	 public void delete(@PathVariable("id") String id){
	    this.noteRepository.deleteById(id);
	 }
    
    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") String id, @RequestBody Note note){
 		this.noteRepository.save(note);
    }
   
	
}
