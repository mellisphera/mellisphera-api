package com.mellisphera.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.mellisphera.entities.Apiary;
import com.mellisphera.repositories.ApiaryRepository;
import com.mellisphera.repositories.DailyWeatherRepository;
import com.mellisphera.repositories.HourlyWeatherRepository;
import com.mellisphera.weather.DailyWeather;
import com.mellisphera.weather.HourlyWeather;
import com.mellisphera.weather._Weather;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RestController
@RequestMapping("/dailyweather")
public class DailyWeatherController {

	@Autowired private DailyWeatherRepository dailyWeatherRepository;
	@Autowired private HourlyWeatherRepository hourlyWeatherRepository;
	@Autowired private ApiaryRepository apiaryRepository;

	public DailyWeatherController() {
	}

	public DailyWeatherController(DailyWeatherRepository dailyWeatherRepository) {
		this.dailyWeatherRepository = dailyWeatherRepository;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces={"application/json"})
	public List<DailyWeather> getAll(){
		int tempMin, tempMax;
		return this.dailyWeatherRepository.findAll();
	}
	
	@RequestMapping(value="/apiary/{idApiary}", method = RequestMethod.GET, produces={"application/json"})
	public List<DailyWeather> getById(@PathVariable("idApiary") String idApiary ){
		return this.dailyWeatherRepository.findDailyWeatherByIdApiary(idApiary);
		
	}

	@RequestMapping(value = "/getMinTemps", method = RequestMethod.GET, produces={"application/json"})
	public List<Float> getMinTemps(){
		//int tempMin, tempMax;
		List<DailyWeather> apiaries=this.dailyWeatherRepository.findAll();
		List<Float> mintemps = new ArrayList<>();
		for(DailyWeather ap : apiaries ) {
			mintemps.add(ap.getMinTempDay());
		}

		return mintemps;
	}



}
