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
@CrossOrigin(origins = {"http://localhost:4200", "http://51.68.71.91:4200","http://51.68.71.91:4300"})
public class HiveController {

	@Autowired
	private HivesRepository HivesRepository; // Interface

	public HiveController() {
	}

	public HiveController(HivesRepository HivesRepository) {
		this.HivesRepository = HivesRepository;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
	public List<Hive> getAll(){
		List<Hive> hives=this.HivesRepository.findAll();
		return hives;
	}

	@RequestMapping(value = "/{username}/{idApiary}", method = RequestMethod.GET, produces={"application/json"}) 
	public List<Hive> getAllUserHives(@PathVariable String username, @PathVariable String idApiary){
		List<Hive> allHives=this.HivesRepository.findAll();
		List<Hive> userApiaryHives = new ArrayList<>();

		for(Hive h : allHives) {
			if(h.getUsername().equals(username) && h.getIdApiary().equals(idApiary)) {
				userApiaryHives.add(h);
			}
		}	
		return userApiaryHives;
	}

	@RequestMapping(value="/{username}/{idApiary}/{idHive}",method=RequestMethod.GET, produces= {"application/Json"})
	public Map<Character,String> coordonnesHiveById(@PathVariable String username, @PathVariable String idApiary,@PathVariable String idHive){
		List<Hive> hive = this.HivesRepository.findAll();
		Map<Character,String> coordonneesHive = new HashMap<>(); 
		for(Hive h : hive) {
			if(username.equals(username) && idApiary.equals(idApiary) && idHive.equals(h.getName())) {
				coordonneesHive.put('x', h.gethivePosX());
				coordonneesHive.put('y', h.gethivePosY());
			}

		}
		return coordonneesHive;
	}

	@PostMapping
	public void insert(@RequestBody Hive hive){
		this.HivesRepository.insert(hive);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
	public void update(@PathVariable("id") String id, @RequestBody Hive hive){ 
		List<Hive> hives= this.HivesRepository.findAll();
		for(Hive h : hives){
			if(h.getId().equals(id)) {
				h.setName(hive.getName());
				h.setDescription(hive.getDescription());
				this.HivesRepository.save(h);
			}
		}
	}
	
	@RequestMapping(value = "/update/coordonnees/{id}", method = RequestMethod.PUT)
	public void updateCoordonnes(@PathVariable("id") String idHive, @RequestBody Hive hive) {
		List<Hive> hives = this.HivesRepository.findAll();
		for(Hive h : hives) {
			if(h.getId().equals(hive.getId())) {
				h.setCoordonnees(hive.gethivePosX(),hive.gethivePosY());
				this.HivesRepository.save(h);
			}
		}
	}
	
	@RequestMapping(value = "/details/{idHive}", method = RequestMethod.GET, produces={"application/json"})
	public Hive getHiveDetails(@PathVariable String idHive){	
		List<Hive> hives = this.HivesRepository.findAll();
		for(Hive h : hives) {
			if(h.getId().equals(idHive)) {
				return h;
			}
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id){
		this.HivesRepository.deleteById(id);
	}

}
