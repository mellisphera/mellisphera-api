package com.mellisphera.controllers;

import java.awt.geom.Arc2D.Float;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.mellisphera.entities.ForecastHourlyWeather;
import com.mellisphera.entities.SimpleSeries;
import com.mellisphera.repositories.ForecastHourlyWeatherRepository;

@RestController
@PreAuthorize("hasRole('PREMIUM') or hasRole('STANDARD') or hasRole('ADMIN')")
@RequestMapping("/forecastHourlyWeather")
public class ForecastHourlyWeatherController {
	
	@Autowired private ForecastHourlyWeatherRepository forecastHourlyRepository;
	
	public ForecastHourlyWeatherController() {
		
	}
	
	@PostMapping("temp/apiary/{idApiary}")
	public List<SimpleSeries> getMainCurrentDailyWeatherByApiary(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.forecastHourlyRepository.findByIdApiaryAndDateBetween(idApiary, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getMain(), _elt.get_origin());
		}).collect(Collectors.toList());
	}
	
	@PostMapping("rain/apiary/{idApiary}")
	public List<SimpleSeries> getRainCurrentDailyWeatherByApiary(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.forecastHourlyRepository.findByIdApiaryAndDateBetween(idApiary, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getRain(), _elt.get_origin());
		}).collect(Collectors.toList());
	}
	
	
	@GetMapping("all")
	public List<ForecastHourlyWeather> getAll() {
		return this.forecastHourlyRepository.findAll();
	}
	

}
