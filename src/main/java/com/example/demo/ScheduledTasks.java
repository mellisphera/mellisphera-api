package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Apiary;
import com.example.demo.entities.weather.HourlyWeather;
import com.example.demo.entities.weather.WeatherAPI;
import com.example.demo.repositories.ApiaryRepository;
import com.example.demo.repositories.HourlyWeatherRepository;
import com.example.demo.controllers.WeatherAPIController;
import com.example.demo.controllers.DailyWeatherController;

@Component
public class ScheduledTasks {

	@Autowired private HourlyWeatherRepository HourlyWeatherRepository;
	@Autowired private ApiaryRepository apiaryRepository;
	
	@Autowired private WeatherAPIController WeatherController;
	@Autowired private DailyWeatherController DailyWeatherController;
	
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //fixed rate is in ms
    /*
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        //System.out.println("Hello");
    }
    */
    // 1 hour = 600 000 ms
   
    // this function update the value of weather in apiaries in the DB
   
    @Scheduled(fixedRate = 100000 )
    public void apiaryWeatherNow() {
    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	
	    List<Apiary> apiaries = this.apiaryRepository.findAll();
	   	
	    log.info("The time is now {}", dateFormat.format(new Date()));
	    
	    for(Apiary ap: apiaries) {
	    	  WeatherAPI weather = new WeatherAPI();
	    	  HourlyWeather h= new HourlyWeather();
	    	  
	    	  weather = this.WeatherController.getActualWeather(ap.getCodePostal());
	    	  System.out.println("ID : "+ap.getId() + " | City : " + weather.getName()+ "|  Temp :"+ weather.getMain().getTemp());
	    	  h.setWeather(weather);
	    	  h.setIdApiary(ap.getId());
	    	  h.setRecordDate(new Date());
	    	  //System.out.println("Apiary ID " + h.getIdApiary());
	    	 
	    	  this.HourlyWeatherRepository.save(h);
	    	  
	    }	
   	}
    
    
    // store results of averageDailyTemperaturePerApiary in DailyWeather 
    public void todayWeatherPerApiary() {
    	 
    }
   	
}