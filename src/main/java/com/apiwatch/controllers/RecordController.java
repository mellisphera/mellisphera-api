package com.apiwatch.controllers;

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

import com.apiwatch.entities.Apiary;
import com.apiwatch.entities.Hive;
import com.apiwatch.entities.Record;
import com.apiwatch.entities.Sensor;
import com.apiwatch.entities.User;
import com.apiwatch.repositories.RecordRepository;

@RestController
@RequestMapping("/records")
@CrossOrigin(origins = {"http://localhost:4200", "http://***REMOVED***:4200","http://***REMOVED***:4300"})
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
    
    @GetMapping("/weightDates")
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
    }
    
}
