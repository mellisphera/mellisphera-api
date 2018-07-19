package com.example.demo.controllers;

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

import com.example.demo.entities.Apiary;
import com.example.demo.entities.Hive;
import com.example.demo.entities.Record;
import com.example.demo.entities.Sensor;
import com.example.demo.entities.User;
import com.example.demo.repositories.RecordRepository;

@RestController
@RequestMapping("/records")
@CrossOrigin(origins = {"http://localhost:4200", "http://54.38.183.109:4200"})
public class RecordController {
	
	@Autowired private RecordRepository RecordRepository;
	Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    public RecordController() {
	    }

    public RecordController(RecordRepository RecordRepository) {
	        this.RecordRepository = RecordRepository;
	        //this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json"})
    public void insert(@RequestBody Record record){
        this.RecordRepository.insert(record);
    }
    
    @GetMapping("/all")
    public List<Record> getAllSensors(){
    List<Record> records=this.RecordRepository.findAll();
    return records;
    }
    
    @GetMapping("/weight")
    public Float[] getJCPWeightRecords(){
    List<Record> records=this.RecordRepository.findAll();
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
    List<Record> records=this.RecordRepository.findAll();
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
