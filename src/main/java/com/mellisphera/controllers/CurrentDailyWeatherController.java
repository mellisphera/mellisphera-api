package com.mellisphera.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mellisphera.entities.CurrentDailyWeather;
import com.mellisphera.entities.SimpleSeries;
import com.mellisphera.repositories.CurrentDailyWeatherRepository;


@RestController
@PreAuthorize("hasRole('PREMIUM') or hasRole('STANDARD') or hasRole('ADMIN')")
@RequestMapping("/dailyWeather")
public class CurrentDailyWeatherController {
	
	@Autowired private CurrentDailyWeatherRepository dailyWearherRepository;
	
	public CurrentDailyWeatherController() {
		
	}
	
	@PostMapping("apiary/{idApiary}")
	public List<SimpleSeries> getCurrentDailyWeatherByApiary(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.dailyWearherRepository.findByIdApiaryAndDateBetween(idApiary, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), new Object[] {_elt.getWeather(), _elt.getMain()}, _elt.get_origin());
		}).collect(Collectors.toList());
	}
	
	@PostMapping("rain/apiary/{idApiary}")
	public List<SimpleSeries> getRainCurrentDailyWeatherByApiary(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.dailyWearherRepository.findByIdApiaryAndDateBetween(idApiary, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getRain(), _elt.get_origin());
		}).collect(Collectors.toList());
	}
}
