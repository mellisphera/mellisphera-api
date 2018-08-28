package com.apiwatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.apiwatch.entities.Apiary;
import com.apiwatch.entities.Hive;
import com.apiwatch.entities.Post;
import com.apiwatch.repositories.HivesRepository;

import java.awt.geom.Arc2D.Float;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/hives")
@CrossOrigin(origins = {"http://localhost:4200", "http://***REMOVED***:4200","http://***REMOVED***:4300"})
public class HiveController {

	@Autowired


    private HivesRepository hivesRepository;

    public HiveController() {
    }

    public HiveController(HivesRepository hivesRepository) {
        this.hivesRepository = hivesRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<Hive> getAll(){
    List<Hive> hives=this.hivesRepository.findAll();
    return hives;
    }
    
    @RequestMapping(value = "/{username}/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public List<Hive> getAllUserHives(@PathVariable String username, @PathVariable String idApiary){
    	List<Hive> userApiaryHives = this.hivesRepository.findHiveByIdApiary(idApiary);
	    return userApiaryHives;
    }
    
    @PostMapping
    public void insert(@RequestBody Hive Hive){
        this.hivesRepository.insert(Hive);
    }
    
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Hive hive){ 
    	Hive h = this.hivesRepository.findHiveById(id);
    	h.setName(hive.getName());
 		h.setDescription(hive.getDescription());
 		this.hivesRepository.save(h);
    }
    
    @RequestMapping(value = "/details/{idHive}", method = RequestMethod.GET, produces={"application/json"})
    public Hive getHiveDetails(@PathVariable String idHive){
    	Hive h = this.hivesRepository.findHiveById(idHive);
    	if (h != null) {
    	    return h;
    	} else {
    		return null;
    	}
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
      this.hivesRepository.deleteById(id);
    }
    
	@RequestMapping(value = "/update/coordonnees/{id}", method = RequestMethod.PUT)
	public void updateHivePos(@PathVariable("id") String id, @RequestBody Hive hive) {
		Hive h = this.hivesRepository.findHiveById(id);
		if(h!=null) {
			h.setHivePos(hive.getHivePosX(), hive.getHivePosY());
			this.hivesRepository.save(h);
		}
	}
	
	@RequestMapping(value="/{username}/{idApiary}/{idHive}",method=RequestMethod.GET, produces= {"application/Json"})
	public Map<Character,String> getPosById(@PathVariable String username, @PathVariable String idApiary,@PathVariable String idHive){
		Map<Character,String> coordonneesHive = new HashMap<>();
		Hive h = this.hivesRepository.findHiveById(idHive);
		if(h!=null && h.getUsername().equals(username)) {
			coordonneesHive.put('x', h.getHivePosX());
			coordonneesHive.put('y', h.getHivePosY());
			return coordonneesHive;
		}
		else {
			return null;
		}
		
	}


}
