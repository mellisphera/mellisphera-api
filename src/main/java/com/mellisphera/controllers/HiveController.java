package com.mellisphera.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.mellisphera.entities.Apiary;
import com.mellisphera.entities.Hive;
import com.mellisphera.entities.Post;
import com.mellisphera.entities.Sensor;
import com.mellisphera.entities.ShareApiary;
import com.mellisphera.entities.User;
import com.mellisphera.repositories.HivesRepository;
import com.mellisphera.repositories.SensorRepository;
import com.mellisphera.repositories.ShareRepository;
import com.mellisphera.repositories.UserRepository;

import java.awt.geom.Arc2D.Float;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/hives")
public class HiveController {

	@Autowired
    private HivesRepository hivesRepository;
	@Autowired private SensorRepository sensorRepository;
	
    public HiveController() {
    }
    
    public HiveController(HivesRepository hivesRepository) {
    	this.hivesRepository = hivesRepository;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<Hive> getAll(){
    List<Hive> hives=this.hivesRepository.findAll();
    for(Hive h: hives) {
    	List<Sensor> sensor = this.sensorRepository.findSensorByIdHive(h.getId());
    	h.setSensor((sensor.size() > 0));
    	this.hivesRepository.save(h);
    }
    return hives;
    }
    @PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "/username/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public List<Hive> getAllUserHives(@PathVariable String idApiary){
    	return this.hivesRepository.findHiveByIdApiary(idApiary);
    }
    
    @PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "/id/{idHive}", method = RequestMethod.GET, produces={"application/json"})
    public Hive getById(@PathVariable String idHive){
    	Hive hiveById = this.hivesRepository.findHiveById(idHive);
	    return hiveById;
    }
    
    @PreAuthorize("hasRole('ADMIN') or hasRole('STANDARD')")
    @RequestMapping(value="/{username}", method = RequestMethod.GET, produces={"application/json"})
    public List<Hive> getAllByUsername(@PathVariable String username){
        return this.hivesRepository.findHiveByUsername(username);
    }
    @PreAuthorize("hasRole('STANDARD')")
    @PostMapping
    public Hive insert(@RequestBody Hive Hive){
        return this.hivesRepository.insert(Hive);
    }
    
    @PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Hive hive){ 
    	Hive h = this.hivesRepository.findHiveById(id);
    	h.setName(hive.getName());
 		h.setDescription(hive.getDescription());
 		h.setIdApiary(hive.getIdApiary());
 		h.setSharingUser(hive.getSharingUser());
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
    
    @PreAuthorize("hasRole('STANDARD')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
      this.hivesRepository.deleteById(id);
    }
    
    @PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "/update/coordonnees/{id}", method = RequestMethod.PUT)
    public void updateHivePos(@PathVariable("id") String id, @RequestBody Hive hive) {
	Hive h = this.hivesRepository.findHiveById(id);
	if(h!=null) {
            h.setHivePos(hive.getHivePosX(), hive.getHivePosY());
            this.hivesRepository.save(h);
	}
    }
	
	/*@RequestMapping(value="/{username}/{idApiary}/{idHive}",method=RequestMethod.GET, produces= {"application/Json"})
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
		
	}*/


}
