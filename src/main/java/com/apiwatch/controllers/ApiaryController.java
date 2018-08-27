package com.apiwatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.apiwatch.entities.Apiary;
import com.apiwatch.repositories.ApiaryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RestController
@RequestMapping("/apiaries")
@CrossOrigin(origins = {"http://localhost:4200", "http://***REMOVED***:4200","http://***REMOVED***:4300"})
public class ApiaryController {
	@Autowired
    private ApiaryRepository apiaryRepository;

    public ApiaryController() {
    }

    public ApiaryController(ApiaryRepository ApiaryRepository) {
        this.apiaryRepository = ApiaryRepository;
    }

    @DeleteMapping("/{id}")
	 public void delete(@PathVariable("id") String id){
	    this.apiaryRepository.deleteById(id);
	 }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<Apiary> getAll(){
	    List<Apiary> apiaries=this.apiaryRepository.findAll();
	    return apiaries;
    }
    
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<Apiary> getAllUserApiaries(@PathVariable String username){
	   /*
    	List<Apiary> allApiaries=this.apiaryRepository.findAll();
	    List<Apiary> userApiaries = new ArrayList<>();
	    
	    for(Apiary a : allApiaries) {
	    	if(a.getUsername().equals(username)) {
	      		userApiaries.add(a);
	    	}
	    }
	    */
    	
    	List<Apiary> userApiaries=this.apiaryRepository.findApiaryByUsername(username);    
	    
	    return userApiaries;
    }
    
    @RequestMapping(value = "/name/{id}", method = RequestMethod.GET, produces={"application/json"})
    public Map<String,String>getRucherCity(@PathVariable String id){
	    
    	/*List<Apiary> allApiaries=this.apiaryRepository.findAll();
	    Map<String,String> rucherName = new HashMap<>();
	    
	    for(Apiary ap : allApiaries) {
		    if(ap.getId().equals(id)) {
		    	rucherName.put("name", ap.getCodePostal());
		    }
    	}
    	
    	return null;
	    */
    	Map<String,String> rucherName = new HashMap<>();
    	Apiary ap = this.apiaryRepository.findApiaryById(id);
    	if (ap != null) {
    		rucherName.put("name", ap.getVille());
        	
    	    return rucherName;
    	} else {
    		return null;
    	}
    	
    }
   
    @RequestMapping(value = "", method = RequestMethod.POST, produces={"application/json"})
    public void insert(@RequestBody Apiary Apiary){
        this.apiaryRepository.insert(Apiary);
    }
    
    @RequestMapping(value = "/details/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public Apiary getApiaryDetails(@PathVariable String idApiary){
    	/*
    	List<Apiary> apiaries = this.apiaryRepository.findAll();
    	    for(Apiary a : apiaries) {
    	    	if(a.getId().equals(idApiary)) {
    	      		return a;
    	    	}
    	    }
    	    return null;
    	*/
    	
    	Apiary a = this.apiaryRepository.findApiaryById(idApiary);
    	return a;
    	    
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Apiary Apiary){ 
    	/* 
    	List<Apiary> apiaries= this.apiaryRepository.findAll();
         for(Apiary a : apiaries){
         	if(a.getId().equals(id)) {
         		a.setName(Apiary.getName());
         		a.setCodePostal(Apiary.getCodePostal());
         		a.setDescription(Apiary.getDescription());
         		this.apiaryRepository.save(a);
         	}
         }*/
    	
    	Apiary a= this.apiaryRepository.findApiaryById(id);
    	a.setName(Apiary.getName());
    	a.setVille(Apiary.getVille());
 		a.setCodePostal(Apiary.getCodePostal());
 		a.setDescription(Apiary.getDescription());
 		this.apiaryRepository.save(a);
    }
   
}
