package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Apiary;
import com.example.demo.entities.Hive;
import com.example.demo.entities.Post;
import com.example.demo.repositories.ApiaryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/apiaries")
@CrossOrigin(origins = {"http://localhost:4200", "http://54.38.183.109:4200"})
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

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
      this.ApiaryRepository.deleteById(id);
    }
   
}
