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
@PreAuthorize("hasRole('PREMIUM') or hasRole('STANDARD') or hasRole('ADMIN')  or hasRole('TEST')")
@RequestMapping("/forecastHourlyWeather")
public class ForecastHourlyWeatherController {
	
	@Autowired private ForecastHourlyWeatherRepository forecastHourlyRepository;
	
	public ForecastHourlyWeatherController() {
		
	}
	
	@PostMapping("temp/apiary/{apiaryId}")
	public List<SimpleSeries> getMainCurrentDailyWeatherByApiary(@PathVariable String apiaryId, @RequestBody Date[] range) {
		return this.forecastHourlyRepository.findByApiaryIdAndDateBetween(apiaryId, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getMain(), _elt.get_origin());
		}).collect(Collectors.toList());
	}
	
	@PostMapping("rain/apiary/{apiaryId}")
	public List<SimpleSeries> getRainCurrentDailyWeatherByApiary(@PathVariable String apiaryId, @RequestBody Date[] range) {
		return this.forecastHourlyRepository.findByApiaryIdAndDateBetween(apiaryId, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getRain(), _elt.get_origin());
		}).collect(Collectors.toList());
	}
	
	@PostMapping("/hourly/apiary/{apiaryId}/{weatherSource}")
	public List<SimpleSeries> getHourlyWeatherByApiaryIdAndDateBetween(@PathVariable String apiaryId, @PathVariable String weatherSource, @RequestBody Date[] range){
		return this.forecastHourlyRepository.findByApiaryIdAndDateBetween(apiaryId, range[0], range[1]).stream().filter(_elt -> _elt.get_origin().contains(weatherSource)).map(_elt -> {
			return new SimpleSeries(_elt.getDate(), new Object[] {_elt.getMain(), _elt.getWind()}, _elt.get_origin());
		}).collect(Collectors.toList());
	}
	
	@GetMapping("all")
	public List<ForecastHourlyWeather> getAll() {
		return this.forecastHourlyRepository.findAll();
	}
	

}
