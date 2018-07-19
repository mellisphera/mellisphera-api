package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.weather.WeatherAPI;
import com.example.demo.repositories.WeatherAPIRepository;

@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = {"http://localhost:4200", "http://54.38.183.109:4200"})
public class WeatherAPIController {
	
	@Autowired WeatherAPIRepository MeteoRepository;

	
	public WeatherAPIController() {
    }

	public WeatherAPIController(WeatherAPIRepository MeteoRepository) {
	        this.MeteoRepository = MeteoRepository;
	}
	
	 @RequestMapping(value="/actualweather/{city}", method=RequestMethod.GET,produces = "application/json")
	    public WeatherAPI  getActualWeather(@PathVariable("city") String city){
		 //String APPID="fcc5291d416eb769b16e70feac848272";
		 String APPID= "110ff02ed24ccd819801248373c3b208";
		 WeatherAPI meteo = new WeatherAPI();
		 RestTemplate restTemplate = new RestTemplate();
		 meteo = restTemplate.getForObject
		 ("https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&APPID="+APPID, WeatherAPI.class);


	     return meteo;
	    }	
	 
	 

}
