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
@CrossOrigin(origins = {"http://localhost:4200", "http://51.68.71.91:4200","http://51.68.71.91:4300"})
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
    List<Sensor> allSensors=this.sensorRepository.findAll();
    
    List<Hive> allHives= this.hivesRepository.findAll();
    List<Apiary> allApiaries= this.apiaryRepository.findAll();
    List<Sensor> userSensors = new ArrayList<>();

    
    for(Apiary a : allApiaries) {
    	System.out.println("a.name : "+ a.getName());
    }
    
    for(Sensor s : allSensors) {
    	if(username!=null && s.getUsername().equals(username)) {
    		for(Apiary a : allApiaries){
    			System.out.println("id Apiary in Sensor : "+ s.getIdApiary()+" id apiary in Apiary : "+a.getId());
    			if(s.getIdApiary()==a.getId()) {
    				System.out.println( "--------------------------------------");
    				//System.out.println("s.getIdApiary() : " + s.getIdApiary() + " a.getId() " + a.getId());
    				//System.out.println( "s.getApiaryName()  : " + s.getApiaryName());
        			s.setApiaryName(a.getName());
        			//System.out.println( "s.getApiaryName()  : " + s.getApiaryName());
        			System.out.println( "--------------------------------------");
        			
    			}
    		}
	    	for(Hive h : allHives)
			{	System.out.println( "--------------------------------------");
					System.out.println("id hive in Sensor : "+ s.getIdHive()+" id hive in HIVE : "+h.getId());
					if(s.getIdHive()==h.getId()) {
	    				
	    				System.out.println("s.getIdHive() : " + s.getIdHive() + " h.getId() " + h.getId());
	    				s.setHiveName(h.getName());
	    				//System.out.println( "s.getHiveName()  : " + s.getHiveName());
	    				System.out.println( "--------------------------------------");
	    				
	    	    	}    		
			}
    		userSensors.add(s);
    	}
    }
    
    return userSensors;
    
    }
    
    @RequestMapping(value = "/weight/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<Sensor> getUserWeightSensors(@PathVariable String username){
    List<Sensor> allSensors=this.sensorRepository.findAll();
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
    	 List<Sensor> sensors= this.sensorRepository.findAll();
         for(Sensor s : sensors){
         	if(s.getId().equals(id) && Sensor.getIdApiary()!=null && Sensor.getIdHive()!=null) {
         		s.setIdHive(Sensor.getIdHive());
         		s.setIdApiary(Sensor.getIdApiary());
         		this.sensorRepository.save(s);
         	}
         }
    }
    

    
    
}
