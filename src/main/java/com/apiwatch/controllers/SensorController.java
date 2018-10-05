package com.apiwatch.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

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

import com.apiwatch.entities.Apiary;
import com.apiwatch.entities.Hive;
import com.apiwatch.entities.Sensor;
import com.apiwatch.entities.User;
import com.apiwatch.repositories.HivesRepository;
import com.apiwatch.repositories.SensorRepository;
import com.apiwatch.repositories.ApiaryRepository;

@RestController
@RequestMapping("/sensors")
public class SensorController {
	
	@Autowired private SensorRepository sensorRepository;
	@Autowired private HivesRepository hivesRepository;
	@Autowired private ApiaryRepository apiaryRepository;
    public SensorController() {
	    }

    public SensorController(SensorRepository sensorRepository) {
	        this.sensorRepository = sensorRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json"})
    public void insert(@RequestBody Sensor Sensor){
        this.sensorRepository.insert(Sensor);
    }
    
    @GetMapping("/all")
    public List<Sensor> getAllSensors(){
    List<Sensor> sensors=this.sensorRepository.findAll();
    return sensors;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
      this.sensorRepository.deleteById(id);
    }
    
    @PutMapping
    public void update(@RequestBody Sensor Sensor){
        this.sensorRepository.save(Sensor);
    }
  
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<Sensor> getUserSensors(@PathVariable String username){
	    List<Sensor> sensors = this.sensorRepository.findSensorByUsername(username);
	    Apiary ap = new Apiary();
	    Hive hv = new Hive();
	    
	    for(Sensor s : sensors) {
	    	ap = this.apiaryRepository.findApiaryById(s.getIdApiary());
	    	hv = this.hivesRepository.findHiveById(s.getIdHive());
	    	if (ap != null) {
	    		s.setApiaryName(ap.getName());
	    	} else {
	    		s.setApiaryName("stock");
	    	}
	    	if (hv != null) {
		    	s.setHiveName(hv.getName());
	    	} else {
		    	s.setHiveName("stock");
	    	}
	    }
	    
	    return sensors;
    
    }
    
    @RequestMapping(value = "/weight/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<Sensor> getUserWeightSensors(@PathVariable String username){
    List<Sensor> allSensors=this.sensorRepository.findSensorByUsername(username);
    List<Sensor> apiarySensors = new ArrayList<>();
    
	    for(Sensor a : allSensors) {
	    	if(a.getType().equals("weight")) {
	    		apiarySensors.add(a);
	    	}
	    }
	    return apiarySensors;
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Sensor sensor){ 
        Sensor s = this.sensorRepository.findSensorById(id);
        s.setIdHive(sensor.getIdHive());
	  	s.setIdApiary(sensor.getIdApiary());
	  	s.setDescription(sensor.getDescription());
	  	this.sensorRepository.save(s);
    }
    

    
    
}
