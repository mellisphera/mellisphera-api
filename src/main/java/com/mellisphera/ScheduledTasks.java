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



package com.mellisphera;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mellisphera.entities.Apiary;
import com.mellisphera.repositories.ApiaryRepository;


@Component
public class ScheduledTasks {
	
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
   
    // this function update the value of weather in apiaries in the DB
    //HOURLY WEATHER
//    @Scheduled(cron = "0 0 * * * *")
//    public void apiaryWeatherNow() {
//    	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//    	
//	    List<Apiary> apiaries = this.apiaryRepository.findAll();
//	   	
//	    log.info("The time is now {}", dateFormat.format(new Date()));
//	    
//	    //for each apiary request actualweather on OWM and save into HourlyWeather collection
//	    for(Apiary ap: apiaries) {
//	    	  WeatherAPI weather = new WeatherAPI();
//	    	  HourlyWeather h= new HourlyWeather();
//	    	  
//	    	  //WARNING : getcodepostal is actually the city name 
//	    	  weather = this.WeatherController.getActualWeather(ap.getVille());
//	    	  System.out.println("ID : "+ap.getId() + " | City : " + weather.getName()+ "|  Temp :"+ weather.getMain().getTemp());
//	    	  h.setWeather(weather);
//	    	  h.setIdApiary(ap.getId());
//	    	  h.setRecordDate(new Date());
//	    	  
//	    	  
//	    	  this.HourlyWeatherRepository.save(h);
//	    	  
//	    }	
//   	}

    
    
    // store results of averageDailyTemperaturePerApiary in DailyWeather 
    public void todayWeatherPerApiary() {
    	 
    }
   	
}