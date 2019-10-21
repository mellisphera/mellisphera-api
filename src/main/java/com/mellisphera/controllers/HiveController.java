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
        return this.hivesRepository.findAll();
    }
    @PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN')")
    @RequestMapping(value = "/username/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
    public List<Hive> getAllUserHives(@PathVariable String idApiary){
    	return this.hivesRepository.findHiveByApiaryId(idApiary);
    }
    
    @PreAuthorize("hasRole('STANDARD')")
    @RequestMapping(value = "/id/{idHive}", method = RequestMethod.GET, produces={"application/json"})
    public Hive getById(@PathVariable String idHive){
    	Hive hiveById = this.hivesRepository.findById(idHive).get();
	    return hiveById;
    }
    
    @PreAuthorize("hasRole('ADMIN') or hasRole('STANDARD')")
    @RequestMapping(value="/{userId}", method = RequestMethod.GET, produces={"application/json"})
    public List<Hive> getAllByUsername(@PathVariable String userId){
        return this.hivesRepository.findHiveByUserId(userId);
    }
    @PreAuthorize("hasRole('STANDARD') or hasRole('PREMIUM') or hasRole('ADMIN')")
    @PostMapping
    public Hive insert(@RequestBody Hive Hive){
        return this.hivesRepository.insert(Hive);
    }
    
    @PreAuthorize("hasRole('STANDARD') or hasRole('ADMIN') or hasRole('PREMIUM')")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Hive hive){ 
 		Hive hiveSave = this.hivesRepository.save(hive);
 		List<Sensor> sensors = this.sensorRepository.findSensorByHiveId(hiveSave.get_id());
 		if (sensors != null) {
 			for(Sensor s: sensors) {
 				if (!s.getHiveName().equals(hiveSave.getName())) {
 					s.setHiveName(hiveSave.getName());
 					this.sensorRepository.save(s);
 				}
 			}
 		}
    }
    
    @RequestMapping(value = "/details/{idHive}", method = RequestMethod.GET, produces={"application/json"})
    public Hive getHiveDetails(@PathVariable String idHive){
    	Hive h = this.hivesRepository.findById(idHive).get();
    	if (h != null) {
    	    return h;
    	} else {
    		return null;
    	}
    }
    
    @PreAuthorize("hasRole('STANDARD') or hasRole('ADMIN') or hasRole('PREMIUM')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
    	List<Sensor> sensorHive = this.sensorRepository.findSensorByHiveId(id);
    	sensorHive.stream().forEach(sensor -> {
    		sensor.setApiaryId(null);
    		sensor.setHiveId(null);
    		this.sensorRepository.save(sensor);
    	});
    	this.hivesRepository.deleteById(id);
    }
    
    @PreAuthorize("hasRole('STANDARD') or hasRole('ADMIN') or hasRole('PREMIUM')")
    @RequestMapping(value = "/update/coordonnees/{id}", method = RequestMethod.PUT)
    public void updateHivePos(@PathVariable("id") String id, @RequestBody Hive hive) {
	Hive h = this.hivesRepository.findById(id).get();
	if(h!=null) {
            h.setHivePosX(hive.getHivePosX());
            h.setHivePosY(hive.getHivePosY());
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
