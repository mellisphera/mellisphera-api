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
import com.example.demo.entities.SoldDevice;
import com.example.demo.entities.User;
import com.example.demo.repositories.SoldDeviceRepository;

@RestController
@RequestMapping("/sold-devices")
@CrossOrigin(origins = {"http://localhost:4200", "http://54.38.183.109:4200"})
public class SoldDeviceController {
	
	@Autowired
    private SoldDeviceRepository SoldDeviceRepository;
	
    public SoldDeviceController() {
	    }

    public SoldDeviceController(SoldDeviceRepository SoldDeviceRepository) {
	        this.SoldDeviceRepository = SoldDeviceRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json"})
    public void insert(@RequestBody SoldDevice SoldDevice){
        this.SoldDeviceRepository.insert(SoldDevice);
    }
    
    @GetMapping("/all")
    public List<SoldDevice> getAll(){
    List<SoldDevice> soldDevices=this.SoldDeviceRepository.findAll();
    return soldDevices;
    }
    
    @GetMapping("/check/{sensorRef}")
    public SoldDevice checkIfSoldDeviceExist(@PathVariable String sensorRef){
    List<SoldDevice> soldDevices=this.SoldDeviceRepository.findAll();
    SoldDevice emptySD = new SoldDevice();
    if(sensorRef != null) {
    	 for(SoldDevice sd : soldDevices) {
    	    	if(sd.getSensorRef().equals(sensorRef)) {
    	    		return sd;
    	    	}
    	    }
    }
   
    return emptySD;
  }
    
    @GetMapping("/check/")
    public SoldDevice checkIfDeviceExist(){
    	SoldDevice sd = new SoldDevice();
    return sd;
  }
   

    
}
