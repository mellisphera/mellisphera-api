package com.example.demo.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Apiary;
import com.example.demo.entities.Hive;
import com.example.demo.entities.Sensor;
import com.example.demo.entities.User;
import com.example.demo.repositories.SensorRepository;

@RestController
@RequestMapping("/sensors")
@CrossOrigin(origins = {"http://localhost:4200", "http://54.38.183.109:4200"})
public class SensorController {
	
	@Autowired
    private SensorRepository SensorRepository;
	
    public SensorController() {
	    }

    public SensorController(SensorRepository SensorRepository) {
	        this.SensorRepository = SensorRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json"})
    public void insert(@RequestBody Sensor Sensor){
        this.SensorRepository.insert(Sensor);
    }
    
    @GetMapping("/all")
    public List<Sensor> getAllSensors(){
    List<Sensor> sensors=this.SensorRepository.findAll();
    return sensors;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
      this.SensorRepository.deleteById(id);
    }
    
    @PutMapping
    public void update(@RequestBody Sensor Sensor){
        this.SensorRepository.save(Sensor);
    }
  
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<Sensor> getUserSensors(@PathVariable String username){
    List<Sensor> allSensors=this.SensorRepository.findAll();
    List<Sensor> apiarySensors = new ArrayList<>();
    
	    for(Sensor a : allSensors) {
	    	if(a.getUsername().equals(username)) {
	    		apiarySensors.add(a);
	    	}
	    }
	    return apiarySensors;
    }
    
    @RequestMapping(value = "/weight/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<Sensor> getUserWeightSensors(@PathVariable String username){
    List<Sensor> allSensors=this.SensorRepository.findAll();
    List<Sensor> apiarySensors = new ArrayList<>();
    
	    for(Sensor a : allSensors) {
	    	if(a.getUsername().equals(username) && a.getType().equals("weight")) {
	    		apiarySensors.add(a);
	    	}
	    }
	    return apiarySensors;
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Sensor Sensor){ 
    	 List<Sensor> sensors= this.SensorRepository.findAll();
         for(Sensor s : sensors){
         	if(s.getId().equals(id) && Sensor.getIdApiary()!=null && Sensor.getIdHive()!=null) {
         		s.setIdHive(Sensor.getIdHive());
         		s.setIdApiary(Sensor.getIdApiary());
         		this.SensorRepository.save(s);
         	}
         }
    }
    
    
    
    /*
    @RequestMapping(value="/test", method=RequestMethod.POST,consumes="application/json", produces = "application/json")
    public List<Sensor> sensors(@RequestBody User u ){    
    	List<Sensor> sensors = this.SensorRepository.findAll();
    	List<Sensor> userSensors = new ArrayList<Sensor>();
    	String username = u.getUsername();
    	  for(Sensor a : sensors) {
  	    	if(a.getUsername().equals(username) ){
  	    		userSensors.add(a);
  	    		System.out.println("a.getUsername() : " + a.getUsername());
  	    		System.out.println("Username : " + u.getUsername());
  	    		//return userSensors;
  	    	}
  	    	//return userSensors;
  	    }
  	    return userSensors;
    }
    */
    
    
}
