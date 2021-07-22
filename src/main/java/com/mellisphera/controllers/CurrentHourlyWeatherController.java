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
@PreAuthorize("hasRole('PREMIUM') or hasRole('STANDARD') or hasRole('ADMIN')  or hasRole('TEST')")
@RequestMapping("/hourlyWeather")
public class CurrentHourlyWeatherController {

	@Autowired private CurrentHourlyWeatherRepository currentHourlyWeatherRepository;
	public CurrentHourlyWeatherController() {
		
	}
	
	@PostMapping("/temp/apiary/{apiaryId}")
	public List<SimpleSeries> getMainCurrentHourlyWeatherByApiary(@PathVariable String apiaryId, @RequestBody Date[] range) {
		return this.currentHourlyWeatherRepository.findByApiaryIdAndDateBetween(apiaryId, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getMain(), _elt.get_origin());
		}).collect(Collectors.toList());
	}
	
	
	
}
