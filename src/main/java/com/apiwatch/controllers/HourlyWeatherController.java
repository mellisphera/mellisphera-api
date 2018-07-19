package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.weather.HourlyWeather;
import com.example.demo.repositories.HourlyWeatherRepository;



@Service
@RestController
@RequestMapping("hourlyweather")
@CrossOrigin(origins = {"http://localhost:4200", "http://54.38.183.109:4200"})
public class HourlyWeatherController {
	
	@Autowired
    private HourlyWeatherRepository HourlyWeatherRepository;

    public HourlyWeatherController() {
    }

    public HourlyWeatherController(HourlyWeatherRepository HourlyWeatherRepository) {
        this.HourlyWeatherRepository = HourlyWeatherRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<HourlyWeather> getAll(){
    List<HourlyWeather> posts=this.HourlyWeatherRepository.findAll();
    return posts;
    }

    @PostMapping
    public void insert(@RequestBody HourlyWeather HourlyWeather){
        this.HourlyWeatherRepository.insert(HourlyWeather);
    }

    /*
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) 
    public void update(@PathVariable("id") String id, @RequestBody Post post){ 
    	 List<Post> posts= this.HourlyWeatherRepository.findAll();
         for(Post p : posts){
         	if(p.getId().equals(id)) {
         		p.setContent(post.getContent());
         		p.setTitle(post.getTitle());
         		p.setLoveIts(post.getLoveIts());
         		this.HourlyWeatherRepository.save(p);
         	}
         }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
      this.HourlyWeatherRepository.deleteById(id);
    }

 
    @GetMapping("getOne/{id}")
    public Post getById(@PathVariable("id") String id){
        List<Post> posts= this.HourlyWeatherRepository.findAll();
        for(Post p : posts){
        	if(p.getId().equals(id)) {
        		return p;
        	}
        }
        return null;
    }
	*/
}
