/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 



package com.mellisphera.controllers;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.fasterxml.jackson.core.sym.Name;
import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.Hive;
import com.mellisphera.entities.Record;
import com.mellisphera.entities.Sensor;
import com.mellisphera.entities.SimpleSeries;
import com.mellisphera.entities.User;
import com.mellisphera.repositories.RecordRepository;

import java.util.Comparator;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/records")
public class RecordController {
		
	@Autowired private RecordRepository recordRepository;
	Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    public RecordController() {
	    }

    public RecordController(RecordRepository recordRepository) {
	        this.recordRepository = recordRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json"})
    public void insert(@RequestBody Record record){
        this.recordRepository.insert(record);
    }
    
    @GetMapping("/all")
    public List<Record> getAllSensors(){
    List<Record> records=this.recordRepository.findAll();
    	return records;
    }
    
    @RequestMapping(value = "/hive/{hiveId}" , method = RequestMethod.POST, produces={"application/json"})
    public ResponseEntity<?> getByhiveId(@PathVariable String hiveId, @RequestBody Date [] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        Date start  = range[0];
        Date end = range[1];
        List<Record> rec = null;
        rec = this.recordRepository.findByHiveIdAndRecordDateBetween(hiveId, start,end, sort);
        if(rec != null) {
        	return new ResponseEntity<>(rec, HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>("Aucune donnée", HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PostMapping("/weight/{hiveId}")
    public ResponseEntity<?> getWeightByHive(@PathVariable String hiveId, @RequestBody Date [] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        Date start  = range[0];
        Date end = range[1];
        
        List<SimpleSeries> data = new ArrayList<SimpleSeries>();
        data = this.recordRepository.findByHiveIdAndRecordDateBetween(hiveId, start,end, sort).stream().filter(_filter  -> _filter.getSensorRef().contains("43")).map(record -> {
        	return new SimpleSeries(record.getRecordDate(), record.getWeight(), record.getSensorRef());
        }).collect(Collectors.toList());
        if(data != null) {
        	return new ResponseEntity<>(data, HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>("Aucune donnée", HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PostMapping("/temp_int/{hiveId}")
    public ResponseEntity<?> getTempByHive(@PathVariable String hiveId, @RequestBody Date [] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        Date start  = range[0];
        Date end = range[1];
        
        List<SimpleSeries> data = new ArrayList<SimpleSeries>();
        data = this.recordRepository.findByHiveIdAndRecordDateBetween(hiveId, start,end, sort).stream()
        		.filter(_filter  -> _filter.getSensorRef().contains("42") || _filter.getSensorRef().contains("41") || _filter.getSensorRef().contains("39") || _filter.getSensorRef().contains("B5")).map(record -> {
        	return new SimpleSeries(record.getRecordDate(), record.getTemp_int(), record.getSensorRef());
        }).collect(Collectors.toList());
        if(data != null) {
        	return new ResponseEntity<>(data, HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>("Aucune donnée", HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PostMapping("/temp_ext/{hiveId}")
    public ResponseEntity<?> getTempExByHive(@PathVariable String hiveId, @RequestBody Date [] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        Date start  = range[0];
        Date end = range[1];
        
        List<SimpleSeries> data = new ArrayList<SimpleSeries>();
        data = this.recordRepository.findByHiveIdAndRecordDateBetween(hiveId, start,end, sort).stream()
        		.filter(_filter  -> _filter.getSensorRef().contains("43")).map(record -> {
        	return new SimpleSeries(record.getRecordDate(), record.getTemp_ext(), record.getSensorRef());
        }).collect(Collectors.toList());
        if(data != null) {
        	return new ResponseEntity<>(data, HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>("Aucune donnée", HttpStatus.NOT_FOUND);
        }
        
    }
    @PostMapping("/hint/{hiveId}")
    public ResponseEntity<?> getHUmidityByHive(@PathVariable String hiveId, @RequestBody Date [] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        Date start  = range[0];
        Date end = range[1];
        
        List<SimpleSeries> data = new ArrayList<SimpleSeries>();
        data = this.recordRepository.findByHiveIdAndRecordDateBetween(hiveId, start,end, sort).stream()
        		.filter(_filter  -> _filter.getSensorRef().contains("42")).map(record -> {
        	return new SimpleSeries(record.getRecordDate(), record.getHumidity_int(), record.getSensorRef());
        }).collect(Collectors.toList());
        if(data != null) {
        	return new ResponseEntity<>(data, HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>("Aucune donnée", HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PostMapping("/batExt/{hiveId}")
    public ResponseEntity<?> getBatteryExtByHive(@PathVariable String hiveId, @RequestBody Date [] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        Date start  = range[0];
        Date end = range[1];
        
        List<SimpleSeries> data = new ArrayList<SimpleSeries>();
        data = this.recordRepository.findByHiveIdAndRecordDateBetween(hiveId, start,end, sort).stream()
        		.filter(_filter  -> _filter.getSensorRef().contains("43")).map(record -> {
        	return new SimpleSeries(record.getRecordDate(), record.getBattery_ext(), record.getSensorRef());
        }).collect(Collectors.toList());
        if(data != null) {
        	return new ResponseEntity<>(data, HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>("Aucune donnée", HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PostMapping("/batInt/{hiveId}")
    public ResponseEntity<?> getBatteryIntByHive(@PathVariable String hiveId, @RequestBody Date [] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        Date start  = range[0];
        Date end = range[1];
        
        List<SimpleSeries> data = new ArrayList<SimpleSeries>();
        data = this.recordRepository.findByHiveIdAndRecordDateBetween(hiveId, start,end, sort).stream()
        		.filter(_filter  -> _filter.getSensorRef().contains("42") || _filter.getSensorRef().contains("41") || _filter.getSensorRef().contains("39") ||  _filter.getSensorRef().contains("B5")).map(record -> {
        	return new SimpleSeries(record.getRecordDate(), record.getBattery_int(), record.getSensorRef());
        }).collect(Collectors.toList());
        if(data != null) {
        	return new ResponseEntity<>(data, HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>("Aucune donnée", HttpStatus.NOT_FOUND);
        }
        
    }
}
