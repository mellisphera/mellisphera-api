package com.apiwatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.apiwatch.entities.Apiary;
import com.apiwatch.entities.Hive;
import com.apiwatch.entities.Post;
import com.apiwatch.repositories.HivesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/hives")
@CrossOrigin(origins = {"http://localhost:4200", "http://51.68.71.91:4200","http://51.68.71.91:4300"})
public class HiveController {
	
	@Autowired
    private HivesRepository HivesRepository;

    public HiveController() {
    }

    public HiveController(HivesRepository HivesRepository) {
        this.HivesRepository = HivesRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<Hive> getAll(){
    List<Hive> hives=this.HivesRepository.findAll();
    return hives;
    }
    
    @RequestMapping(value = "/{username}/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public List<Hive> getAllUserHives(@PathVariable String username, @PathVariable String idApiary){
    List<Hive> allHives=this.HivesRepository.findAll();
    List<Hive> userApiaryHives = new ArrayList<>();
    
	    for(Hive h : allHives) {
	    	if(h.getUsername().equals(username) && h.getIdApiary().equals(idApiary)) {
	    		userApiaryHives.add(h);
	    	}
	    }
	    return userApiaryHives;
    }
    
    @PostMapping
    public void insert(@RequestBody Hive Hive){
        this.HivesRepository.insert(Hive);
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Hive hive){ 
    	 List<Hive> hives= this.HivesRepository.findAll();
         for(Hive h : hives){
         	if(h.getId().equals(id)) {
         		h.setName(hive.getName());
         		h.setDescription(hive.getDescription());
         		this.HivesRepository.save(h);
         	}
         }
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
      this.HivesRepository.deleteById(id);
    }

    /*
    @RequestMapping(value = "/", method = RequestMethod.POST, produces={"application/json"})
    public List<Hive> getAllHives(){
    List<Hive> hives = this.HivesRepository.find
    return hives;
    }
  
  
    
   
/*
    @GetMapping("/notes/{id}")
    public List<Note> getNoteRucheById(@PathVariable("id") String id){
    	List<Ruche> ruches =  this.RucheRepository.findAll();
    	List<Note> notes= new ArrayList<>();
    	for(Ruche r : ruches) {
    		if(r.getId().equals(id)) {
    			notes=r.getNotesRuches();
    		}
    	}
        return notes;
    }
  */
    /*
    @GetMapping("/captures/{id}")
    public List<Record> getCaptureRucheById(@PathVariable("id") String id){
    	List<Ruche> ruches =  this.HiveRepository.findAll();
    	List<Record> captures= new ArrayList<>();
    	for(Ruche r : ruches) {
    		if(r.getId().equals(id)) {
    			captures=r.getCapturesRuches();
    		}
    	}
        return captures;
    }
 */
    //update notes to develop
    /*
    @GetMapping("/{id}")
    public Optional<Ruche> getRucheById(@PathVariable("id") String id){
        Optional<Ruche> Ruche = this.RucheRepository.findById(id);
        return Ruche;
    }
    */
}
