package com.apiwatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.apiwatch.controllers.DailyWeatherController;
import com.apiwatch.controllers.WeatherAPIController;
import com.apiwatch.entities.Apiary;
import com.apiwatch.repositories.ApiaryRepository;
import com.apiwatch.repositories.HourlyWeatherRepository;
import com.apiwatch.weather.HourlyWeather;
import com.apiwatch.weather.WeatherAPI;
//***********************************************
//Current implementation : request hourly weather
//***********************************************

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
    
    @Scheduled(fixedRate = 300000 )
    public void apiaryWeatherNow() {
    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    	
	    List<Apiary> apiaries = this.apiaryRepository.findAll();
	   	
	    log.info("The time is now {}", dateFormat.format(new Date()));
	    
	    //for each apiary request actualweather on OWM and save into HourlyWeather collection
	    for(Apiary ap: apiaries) {
	    	  WeatherAPI weather = new WeatherAPI();
	    	  HourlyWeather h= new HourlyWeather();
	    	  
	    	  //WARNING : getcodepostal is actually the city name 
	    	  weather = this.WeatherController.getActualWeather(ap.getVille());
	    	  System.out.println("ID : "+ap.getId() + " | City : " + weather.getName()+ "|  Temp :"+ weather.getMain().getTemp());
	    	  h.setWeather(weather);
	    	  h.setIdApiary(ap.getId());
	    	  h.setRecordDate(new Date());
	    	  
	    	  
	    	  this.HourlyWeatherRepository.save(h);
	    	  
	    }	
   	}
    
    //Fires at 11 PM every day:
    @Scheduled(cron = "0 0 11 * * ?")
    public void dailyWeather() {
    	DailyWeatherController.dailyWeatherCompute();
   	}
    
    
    // store results of averageDailyTemperaturePerApiary in DailyWeather 
    public void todayWeatherPerApiary() {
    	 
    }
   	
}