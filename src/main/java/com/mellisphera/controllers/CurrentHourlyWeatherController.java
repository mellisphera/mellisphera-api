package com.mellisphera.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.CurrentHourlyWeather;
import com.mellisphera.entities.ForecastHourlyWeather;
import com.mellisphera.entities.SimpleSeries;
import com.mellisphera.repositories.CurrentHourlyWeatherRepository;

@RestController
@PreAuthorize("hasRole('PREMIUM') or hasRole('STANDARD') or hasRole('ADMIN')")
@RequestMapping("/hourlyWeather")
public class CurrentHourlyWeatherController {

	@Autowired private CurrentHourlyWeatherRepository currentHourlyWeatherRepository;
	public CurrentHourlyWeatherController() {
		
	}
	
	@PostMapping("/temp/apiary/{idApiary}")
	public List<SimpleSeries> getMainCurrentHourlyWeatherByApiary(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.currentHourlyWeatherRepository.findByIdApiaryAndDateBetween(idApiary, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getMain(), _elt.get_origin());
		}).collect(Collectors.toList());
	}
	
	
	
}
