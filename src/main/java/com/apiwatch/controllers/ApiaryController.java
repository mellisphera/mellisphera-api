package com.apiwatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.apiwatch.entities.Apiary;
import com.apiwatch.entities.Hive;
import com.apiwatch.entities.Post;
import com.apiwatch.repositories.ApiaryRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/apiaries")
@CrossOrigin(origins = {"http://localhost:4200", "http://***REMOVED***:4200","http://***REMOVED***:4300"})
public class ApiaryController {
	@Autowired
    private ApiaryRepository ApiaryRepository;

    public ApiaryController() {
    }

    public ApiaryController(ApiaryRepository ApiaryRepository) {
        this.ApiaryRepository = ApiaryRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<Apiary> getAll(){
    List<Apiary> apiaries=this.ApiaryRepository.findAll();
    return apiaries;
    }
    
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<Apiary> getAllUserApiaries(@PathVariable String username){
	    List<Apiary> allApiaries=this.ApiaryRepository.findAll();
	    List<Apiary> userApiaries = new ArrayList<>();
	    
	    for(Apiary a : allApiaries) {
	    	if(a.getUsername().equals(username)) {
	      		userApiaries.add(a);
	    	}
	    }
	    return userApiaries;
    }
    
    @RequestMapping(value = "/name/{id}", method = RequestMethod.GET, produces={"application/json"})
    public Map<String,String>getRucherCity(@PathVariable String id){
	    List<Apiary> allApiaries=this.ApiaryRepository.findAll();
	    
	    Map<String,String> rucherName = new HashMap<>();
	    for(Apiary ap : allApiaries) {
		    if(ap.getId().equals(id)) {
		    	rucherName.put("name", ap.getCodePostal());
		    }
    	}
	    
	    return rucherName;
    }
   
    @RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json"})
    public void insert(@RequestBody Apiary Apiary){
        this.ApiaryRepository.insert(Apiary);
    }
    
    @RequestMapping(value = "/details/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public Apiary getApiaryDetails(@PathVariable String idApiary){
    List<Apiary> apiaries = this.ApiaryRepository.findAll();
    	    for(Apiary a : apiaries) {
    	    	if(a.getId().equals(idApiary)) {
    	      		return a;
    	    	}
    	    }
    	    return null;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Apiary Apiary){ 
    	 List<Apiary> apiaries= this.ApiaryRepository.findAll();
         for(Apiary a : apiaries){
         	if(a.getId().equals(id)) {
         		a.setName(Apiary.getName());
         		a.setCodePostal(Apiary.getCodePostal());
         		a.setDescription(Apiary.getDescription());
         		this.ApiaryRepository.save(a);
         	}
         }
    }
   
}
