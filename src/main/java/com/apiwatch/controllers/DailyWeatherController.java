package com.apiwatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.apiwatch.entities.Apiary;
import com.apiwatch.repositories.ApiaryRepository;
import com.apiwatch.repositories.DailyWeatherRepository;
import com.apiwatch.repositories.HourlyWeatherRepository;
import com.apiwatch.weather.DailyWeather;
import com.apiwatch.weather.HourlyWeather;
import com.apiwatch.weather._Weather;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

@Service
@RestController
@RequestMapping("/dailyweather")
@CrossOrigin(origins = {"http://localhost:4200", "http://***REMOVED***:4200","http://***REMOVED***:4300"})
public class DailyWeatherController {
	@Autowired private DailyWeatherRepository DailyWeatherRepository;
	@Autowired private HourlyWeatherRepository HourlyWeatherRepository;
	@Autowired private ApiaryRepository ApiaryRepository;
    public DailyWeatherController() {
    }

    public DailyWeatherController(DailyWeatherRepository DailyWeatherRepository) {
        this.DailyWeatherRepository = DailyWeatherRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
    public List<DailyWeather> getAll(){
    int tempMin, tempMax;
    List<DailyWeather> apiaries=this.DailyWeatherRepository.findAll();
    return apiaries;
    }
    
    @RequestMapping(value = "/getMinTemps", method = RequestMethod.GET, produces={"application/json"})
    public List<Float> getMinTemps(){
    //int tempMin, tempMax;
    List<DailyWeather> apiaries=this.DailyWeatherRepository.findAll();
    List<Float> mintemps = new ArrayList<>();
	    for(DailyWeather ap : apiaries ) {
	    	mintemps.add(ap.getMinTempDay());
	    }
    
    return mintemps;
    }

    //Service to retrieve daily weather in every Apiary
    @RequestMapping(value = "", method = RequestMethod.GET, produces={"application/json"})
    public List<DailyWeather> maxTempPerApiary() {
    	
    	List<DailyWeather> dailyWeather = new ArrayList<>();
    	
     	List<HourlyWeather> hourlyWeatherAll=this.HourlyWeatherRepository.findAll();
     	List<HourlyWeather> hourlyWeatherToday = new ArrayList<>();
     	
     	DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
     	
	 	for(HourlyWeather hw : hourlyWeatherAll) {
	    		
	    		Date dateSunrise = new Date(hw.getWeather().getSys().getSunrise()*1000L); // convert seconds to milliseconds
	    		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"); // the format of your date
	    		String formattedDate = dateFormat.format(dateSunrise);
	    		System.out.println(formattedDate); 
	    		
	    		Date dateSunset = new Date(hw.getWeather().getSys().getSunset()*1000L); // convert seconds to milliseconds
	    		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z"); // the format of your date
	    		String formattedDate2 = dateFormat.format(dateSunrise);
	    		System.out.println(formattedDate2); 
	    		
	    		//hw.getRecordDate().after(dateSunrise)
	
	    		if(hw.getRecordDate().after(dateSunrise) && hw.getRecordDate().before(dateSunset)) {
	    			if(df.format(hw.getRecordDate()).equals(df.format(new Date()))){
			    		   hourlyWeatherToday.add(hw);
			    		}
	    		}
	    	}

     	//Group Hourly Weather Per Apiary
     	Map<String, List<HourlyWeather>> hourlyWeatherPerApiary = hourlyWeatherToday.stream()
     			  .collect(Collectors.groupingBy(hw -> hw.getIdApiary()));


     	//loop every HourlyWeather recorded in DB
     	for(Map.Entry<String, List<HourlyWeather>> entry : hourlyWeatherPerApiary.entrySet()) {
     		  
     		  DailyWeather day = new DailyWeather();
     		  //list of icons
     		  List<String> icons =  new ArrayList<>();
	   		  //key is the id of the Apiary
     		  String key = entry.getKey();
     		  //list of recorded temperatures
	   		  List<Float> temps = new  ArrayList<>();
	   		  
	   		  
	   		  //add the temps of every apiary to a list
	   		  for (HourlyWeather value : entry.getValue()) {
	   			  temps.add(value.getWeather().getMain().getTemp());
	   			  
	   			  for(_Weather w : value.getWeather().getWeather()) {
	   				  //add icon if it doesn't exist in icons list
	   				  if(!icons.contains(w.getIcon())) {
	   					  icons.add(w.getIcon());
		   				  System.out.println(w.getIcon());
	   				  }
	   			  }
	   		  }
	   		  //Affect max temp to the first value of the list
	   		  Float maxTemp= temps.get(0);
	   		  Float minTemp= temps.get(0);
	   		  Float avgTemp = 0.0f;
	   		  Float cumTemp = 0.0f;
	   		  int i=0;
	   		  //loop in list of temps and get the max temp
	   		  for(Float f : temps ) {
	   			  if(f > maxTemp) {
	   				maxTemp=f;
	   			  }
	   		  }
	   		  //loop in list of temps and get the min temp
	   		  for(Float f : temps ) {
	   			  if(f < minTemp) {
	   				minTemp=f;
	   			  }
	   		  }
	   		  
	   		  for(Float f : temps ) {
	   			cumTemp=cumTemp+f;
	   			i++;
	   		  }
	   		  avgTemp= cumTemp / i ;
	   
	   		  System.out.println("icons.size() : " + icons.size());
	   		  // loop icons and decide which icon to store and display	    		
					if(icons.size()==1) {
						//icons.addAll(icons);
						day.setIcons(icons);
						System.out.println("icons.contains(\"01d\") : " + icons.contains("01d"));
					
					}
					
					else if(icons.contains("01d") && icons.contains("02d")) {
						icons.remove("01d");
						day.setIcons(icons);
					}
					
					else if(icons.contains("01d") && icons.contains("02d")) {
						icons.remove("01d");
						day.setIcons(icons);
					}
					
					else if(icons.contains("01d") || icons.contains("02d") && icons.contains("03d") || icons.contains("04d") ) {
						icons.remove("01d");
						icons.remove("03d");
						icons.remove("04d");
						day.setIcons(icons);
					}
					else if(icons.contains("01d") || icons.contains("02d") && 
					   icons.contains("09d") || icons.contains("10d") ||
					   icons.contains("11d") || icons.contains("13d") ) {
						
						icons.remove("01d");
						icons.remove("02d");
						icons.remove("13d");
						icons.remove("09d");
						icons.remove("11d");
						day.setIcons(icons);
					}
					
					else if(icons.contains("03d") || icons.contains("04d") && icons.contains("09d") ||
	    			       icons.contains("11d") || icons.contains("13d") ) {
	    						
	    						icons.remove("03d");
	    						icons.remove("04d");
	    						icons.remove("11d");
	    						icons.remove("13d");
	    						day.setIcons(icons);
	    					}

					else if(icons.contains("03d") || icons.contains("04d") && icons.contains("10d") ) {
						
	    						icons.remove("03d");
	    						icons.remove("04d");	
	    						day.setIcons(icons);
	    					}
					
					else if(icons.contains("01d") || icons.contains("02d") && icons.contains("03d") || icons.contains("04d") && 
							icons.contains("09d") || icons.contains("10d") || icons.contains("11d") || icons.contains("13d")) {
	 	    						icons.remove("01d");
	 	    						icons.remove("02d");
	 	    						icons.remove("03d");
	 	    						icons.remove("04d");
	 	    						icons.remove("09d");
	 	    						icons.remove("11d");
	 	    						icons.remove("03d");
	 	    						day.setIcons(icons);
	 	    					}


					else {
							icons.clear();
							icons.add("?");
							day.setIcons(icons);
					}  			  
	   		 
	     		  
	   		 day.setMaxTempDay(maxTemp);
	   		 day.setMinTempDay(minTemp);
	   		 day.setAvgTempDay(avgTemp);
	   		 //day.setIcons(icons);
	   		 day.setIdApiary(key);
	   		 day.setDay(new Date());
	   	   	 dailyWeather.add(day);
	   		
	   		  //Affect the min temp to its Apiary
	   		//maxtempPerApiary.put(key,maxTemp);
   		}
     	
     	return dailyWeather;
    }
    

}
