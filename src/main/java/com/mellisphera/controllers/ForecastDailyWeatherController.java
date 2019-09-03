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

import com.mellisphera.entities.ForecastDailyWeather;
import com.mellisphera.entities.SimpleSeries;
import com.mellisphera.repositories.ForecastDailyWeatherRepository;

@RestController
@PreAuthorize("hasRole('PREMIUM') or hasRole('STANDARD') or hasRole('ADMIN')")
@RequestMapping("/forecastDailyWeather")
public class ForecastDailyWeatherController {

	@Autowired private ForecastDailyWeatherRepository forecastDailyWeatherRepository;
	
	public ForecastDailyWeatherController() {
		
	}
	
	@PostMapping("apiary/{idApiary}")
	public List<SimpleSeries> getCurrentDailyWeatherByApiary(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.forecastDailyWeatherRepository.findByIdApiaryAndDateBetween(idApiary, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), new Object[] {_elt.getWeather(), _elt.getMain()}, _elt.get_origin());
		}).collect(Collectors.toList());
	}
	
	@PostMapping("rain/apiary/{idApiary}")
	public List<SimpleSeries> getRainCurrentDailyWeatherByApiary(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.forecastDailyWeatherRepository.findByIdApiaryAndDateBetween(idApiary, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getRain(), _elt.get_origin());
		}).collect(Collectors.toList());
	}

	@PostMapping("tExt/apiary/{idApiary}")
	public List<SimpleSeries> getTempMax(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.forecastDailyWeatherRepository.findByIdApiaryAndDateBetween(idApiary, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getMain(), _elt.get_origin());
		}).collect(Collectors.toList());
	}
	@PostMapping("wind/apiary/{idApiary}")
	public List<SimpleSeries> getWind(@PathVariable String idApiary, @RequestBody Date[] range) {
		return this.forecastDailyWeatherRepository.findByIdApiaryAndDateBetween(idApiary, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getWind(), _elt.get_origin());
		}).collect(Collectors.toList());
	}
}

