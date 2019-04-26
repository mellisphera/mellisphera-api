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

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.Hive;
import com.mellisphera.entities.Record;
import com.mellisphera.entities.Sensor;
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
    
    @RequestMapping(value = "/hive/{idHive}" , method = RequestMethod.POST, produces={"application/json"})
    public ResponseEntity<?> getByIdHive(@PathVariable String idHive, @RequestBody Date [] range){
        Sort sort = new Sort(Direction.DESC, "timestamp");
        Date start  = range[0];
        Date end = range[1];
        List<Record> rec = null;
        rec = this.recordRepository.findByIdHiveAndRecordDateBetween(idHive, start,end, sort);
        if(rec != null) {
        	return new ResponseEntity<>(rec, HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>("Aucune donnée", HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping("/weight")
    public Float[] getJCPWeightRecords(){
    List<Record> records=this.recordRepository.findAll();
    List<Float> weightList = new ArrayList<>();
    
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    for(Record r : records) {
    	//df.parse(r.getRecordDate());
    	//weightRecords.add(r.getWeight());
	    	if(r.getSensorRef().equals("43:10:A2"))
	    	{
	    		weightList.add(r.getWeight());
	    	}
    	}
    Float[] recArray = new Float[weightList.size()];
    recArray = weightList.toArray(recArray);
    
    return recArray;
    }
    
    /*@GetMapping("/weightDates")
    public String[] getJCPWeightRecordDates(){
    List<Record> records=this.recordRepository.findAll();
    List<String> weightDates = new ArrayList<>();
    
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    for(Record r : records) {
    	if(r.getSensorRef().equals("43:10:A2"))
    	{
    		//String s = formatter.format();
    		weightDates.add(r.getRecordDate().substring(0,19));
    	}
    }
    
    String[] recArray = new String[weightDates.size()];
    recArray = weightDates.toArray(recArray);
    
    return recArray;
    }*/
    
}
