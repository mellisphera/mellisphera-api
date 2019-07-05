package com.mellisphera.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.ForecastDailyWeather;
import com.mellisphera.repositories.ForecastDailyWeatherRepository;

@RestController
@PreAuthorize("hasRole('PREMIUM') or hasRole('STANDARD') or hasRole('ADMIN')")
@RequestMapping("/forecastDailyWeather")
public class ForecastDailyWeatherController {

	@Autowired private ForecastDailyWeatherRepository forecastDailyWeatherRepository;
	
	public ForecastDailyWeatherController() {
		
	}
	
	@PostMapping("apiary/{idApiary}")
	public List<ForecastDailyWeather> getCurrentDailyWeatherByApiary(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.forecastDailyWeatherRepository.findByIdApiaryAndDateBetween(idApiary, range[0], range[1]);
	}
}
