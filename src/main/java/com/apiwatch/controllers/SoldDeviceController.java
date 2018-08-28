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
import com.apiwatch.entities.SoldDevices;
import com.apiwatch.entities.User;
import com.apiwatch.repositories.SoldDevicesRepository;
import com.apiwatch.entities.SoldDevices;

@RestController
@RequestMapping("/sold_devices")
@CrossOrigin(origins = {"http://localhost:4200", "http://51.68.71.91:4200","http://51.68.71.91:4300"})
public class SoldDeviceController {
	
	@Autowired
    private SoldDevicesRepository soldDevicesRepository;
	
    public SoldDeviceController() {
	    }

    public SoldDeviceController(SoldDevicesRepository soldDeviceRepository) {
	        this.soldDevicesRepository = soldDeviceRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json"})
    public void insert(@RequestBody SoldDevices soldDevice){
        this.soldDevicesRepository.insert(soldDevice);
    }
    
    @GetMapping("/all")
    public List<SoldDevices> getAll(){
    List<SoldDevices> soldDevices=this.soldDevicesRepository.findAll();
    return soldDevices;
    }
    
    @GetMapping("/check/{sensorRef}")
    public SoldDevices checkIfSoldDeviceExist(@PathVariable String sensorRef){
    	
	    List<SoldDevices> soldDevices = this.soldDevicesRepository.findSoldDevicesBySensorRef(sensorRef);
	    SoldDevices emptySD = new SoldDevices();
	    
	    if(!soldDevices.isEmpty()) {
	    	 return soldDevices.get(0);
	    }
	   
	    return emptySD;
    }
    
    @GetMapping("/check/")
    public SoldDevices checkIfDeviceExist(){
    	SoldDevices sd = new SoldDevices();
    return sd;
  }
   

    
}
