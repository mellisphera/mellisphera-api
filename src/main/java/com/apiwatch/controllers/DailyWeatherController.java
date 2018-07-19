package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Apiary;
import com.example.demo.entities.weather.DailyWeather;
import com.example.demo.entities.weather._Weather;
import com.example.demo.entities.weather.HourlyWeather;
import com.example.demo.repositories.DailyWeatherRepository;
import com.example.demo.repositories.HourlyWeatherRepository;
import com.example.demo.repositories.ApiaryRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@RestController
@RequestMapping("/dailyweather")
@CrossOrigin(origins = {"http://localhost:4200", "http://54.38.183.109:4200"})
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

    @RequestMapping(value = "/average/weather/apiary", method = RequestMethod.GET, produces={"application/json"})
    public HashMap<String,DailyWeather> averageDailyTemperaturePerApiary(){
    	
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
	    	List<HourlyWeather> hourlyWeatherAll=this.HourlyWeatherRepository.findAll();
	    	//contain all apiary weather records of today
	    	List<HourlyWeather> hourlyWeatherToday = new ArrayList<>();
	    	List<Apiary> apiaries=this.ApiaryRepository.findAll();
	    	

	    	//get the hourlyWeather of today
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
	    	
	    	HashMap<String,Integer> nbOccurences = new HashMap<>();
	    	
	    	// store all apiaries in the nbOccurences Map 
	    	for(Apiary ap : apiaries) {
	    		if (!nbOccurences.containsKey(ap.getId())) {
	    			nbOccurences.put(ap.getId(),0);
	    			System.out.println("ap.getId() : " + ap.getId());
	    		}
	    	}
	    	
	    	// Calculate nbOccurences for each record in HourlyWeatherToday
	    	for(HourlyWeather hwt: hourlyWeatherToday) {
	    		System.out.println("nbOccurences.containsKey(hwt.getIdApiary()) : " + nbOccurences.containsKey(hwt.getIdApiary()));
	    		if (nbOccurences.containsKey(hwt.getIdApiary())) {
	    			System.out.println();
	    			nbOccurences.computeIfPresent(hwt.getIdApiary(), (k,v) -> nbOccurences.get(hwt.getIdApiary()) + 1 );
	    		}
	    	}
	    	
	    	for(String idApiary: nbOccurences.keySet()) {
	    		String key =idApiary.toString();
	            String value = nbOccurences.get(idApiary).toString();  
	            System.out.println("Key : "+ key + " | Value " + value);
	    	}
	    	
	    	// String = idApiary, Float=Temp
	    	HashMap<String,DailyWeather> myMap = new HashMap<>();
	    	
	    	for(HourlyWeather hwt: hourlyWeatherToday) {
	    		
	    		if (!myMap.containsKey(hwt.getIdApiary())) {
	    			DailyWeather dw = new DailyWeather();
	    			dw.setIdApiary(hwt.getIdApiary());
	    			dw.setDay(new Date());
	    			dw.setMaxTempDay(0.0f);
	    			dw.setMinTempDay(0.0f);
	    			myMap.put(hwt.getIdApiary(),dw);
	    		}
	    		
	    		if (myMap.containsKey(hwt.getIdApiary())) {
	    			int n=nbOccurences.get(hwt.getIdApiary()) ;
	    			System.out.println("n : "+ n); 
	    			DailyWeather tempNow = myMap.get(hwt.getIdApiary());
	    			System.out.println("Temp now : "+ tempNow + "| id APIARY : " + hwt.getIdApiary()+ " | nb occurences " + n + "| hwt.getTemp() : " + hwt.getWeather().getMain().getTemp_max()); 
	    			
	    			if(n!=0) {
	    				DailyWeather existingDw= new DailyWeather();
	    					    	
	    				Float newMaxTempValue = ( tempNow.getMaxTempDay() + hwt.getWeather().getMain().getTemp_max() / n);
	    				Float newMinTempvalue = (tempNow.getMinTempDay()+ hwt.getWeather().getMain().getTemp_min()/ n);
	    				existingDw.setMaxTempDay(newMaxTempValue); 
	    				existingDw.setMinTempDay(newMinTempvalue);
	    				//existingDw.setIcons(tempNow.getIcons().add(hwt.getWeather().getWeather().));
	    				
	    				//pour récupérer l'icone actuelle
	    				List<_Weather> weather_icons= hwt.getWeather().getWeather();
	    				List<String> icons = new ArrayList<>();
	    				
	    				if(tempNow.getIcons()!=null) {	    			
	    					icons.addAll(tempNow.getIcons());
	    				}
	    				for(_Weather wi : weather_icons) {
	    					if(!icons.contains(wi.getIcon()))
	    					icons.add(wi.getIcon());
	    				}
	    				existingDw.setIcons(icons);
	    				existingDw.setDay(new Date());
	    				existingDw.setIdApiary(hwt.getIdApiary());
	    				myMap.put(hwt.getIdApiary(),existingDw);
	    				
	    			}

	    		}
	    	
	    	}
	    	
	    	for (Map.Entry<String, DailyWeather> entry : myMap.entrySet())
	    	{
	    	      this.DailyWeatherRepository.save(entry.getValue());
	    		  System.out.println("entry.getValue() : " + entry.getValue());
	    	}
	    		
	    	return myMap;
    }

    	
  	
   	
  	
}
