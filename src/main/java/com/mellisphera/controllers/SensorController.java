package com.mellisphera.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
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

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.Hive;
import com.mellisphera.entities.Sensor;
import com.mellisphera.entities.User;
import com.mellisphera.repositories.ApiaryRepository;
import com.mellisphera.repositories.HivesRepository;
import com.mellisphera.repositories.SensorRepository;

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
    public Sensor insert(@RequestBody Sensor sensor){
        Hive hive = this.hivesRepository.findHiveById(sensor.getIdHive());
        hive.setSensor(true);
        this.hivesRepository.save(hive);
        return this.sensorRepository.insert(sensor);
    }
    
    @GetMapping("/all")
    public List<Sensor> getAllSensors(){
    List<Sensor> sensors=this.sensorRepository.findAll();
    return sensors;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
    Hive hive = this.hivesRepository.findHiveById(this.sensorRepository.findById(id).get().getIdHive());
    if (hive != null) {
    	hive.setSensor(false);
    	this.hivesRepository.save(hive);
    }
    this.sensorRepository.deleteById(id);
    }
    
    @PutMapping
    public void update(@RequestBody Sensor sensor){
    	Sensor lastSensor = this.sensorRepository.findSensorById(sensor.getId());
    	if (!lastSensor.getIdHive().equals(sensor.getIdHive())) {
    		Hive lastHive = this.hivesRepository.findById(lastSensor.getIdHive()).get();
    		Hive newHive = this.hivesRepository.findById(sensor.getIdHive()).get();
    		System.out.println(lastHive);
    		if (lastHive != null) {
    			lastHive.setSensor(false);
    		}
    		if (newHive != null) {
    			newHive.setSensor(true);
    		}
    	}
        this.sensorRepository.save(sensor);
    }
  
    @GetMapping(value="/check/{reference}")
    public Sensor checkSensor(@PathVariable String reference) {
    	//System.err.println(this.sensorRepository.findSensorsByReference(reference).getReference());
    	return this.sensorRepository.findSensorsByReference(reference);
    	//return (this.sensorRepository.findSensorsByReference(reference) != null ? true : false) ;
    }
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<Sensor> getUserSensors(@PathVariable String username){
    	// liste les capteurs pour un user
	    List<Sensor> sensors = this.sensorRepository.findSensorByUsername(username);
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
    	Sensor lastSensor = this.sensorRepository.findSensorById(sensor.getId());
    	if (!lastSensor.getIdHive().equals(sensor.getIdHive())) {
    		try {
    			Hive lastHive = this.hivesRepository.findById(lastSensor.getIdHive()).get();
        		if (lastHive != null) {
        			lastHive.setSensor(false);
        			this.hivesRepository.save(lastHive);
        		}
    		}
    		catch(NoSuchElementException e) {}
    		Hive newHive = this.hivesRepository.findById(sensor.getIdHive()).get();
    		System.err.println(newHive);
    		if (newHive != null) {
    			newHive.setSensor(true);
    			this.hivesRepository.save(newHive);
    		}
    	}
	  	this.sensorRepository.save(sensor);
    }
    

    
    
}
