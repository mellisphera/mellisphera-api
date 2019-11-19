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
	
	@PostMapping("apiary/{apiaryId}")
	public List<SimpleSeries> getCurrentDailyWeatherByApiary(@PathVariable String apiaryId, @RequestBody Date[] range) {
		return this.dailyWearherRepository.findByApiaryIdAndDateBetween(apiaryId, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), new Object[] {_elt.getWeather(), _elt.getMain()}, _elt.get_origin());
		}).collect(Collectors.toList());
	}
	
	@PostMapping("rain/apiary/{apiaryId}")
	public List<SimpleSeries> getRainCurrentDailyWeatherByApiary(@PathVariable String apiaryId, @RequestBody Date[] range) {
		return this.dailyWearherRepository.findByApiaryIdAndDateBetween(apiaryId, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(),  new Object[] {_elt.getRain(), _elt.getSnow()}, _elt.get_origin());
		}).collect(Collectors.toList());
	}

	@PostMapping("tExt/apiary/{apiaryId}")
	public List<SimpleSeries> getTempMax(@PathVariable String apiaryId, @RequestBody Date[] range) {
		return this.dailyWearherRepository.findByApiaryIdAndDateBetween(apiaryId, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getMain(), _elt.get_origin());
		}).collect(Collectors.toList());
	}

	@PostMapping("wind/apiary/{apiaryId}")
	public List<SimpleSeries> getWind(@PathVariable String apiaryId, @RequestBody Date[] range) {
		return this.dailyWearherRepository.findByApiaryIdAndDateBetween(apiaryId, range[0], range[1]).stream().map(_elt -> {
			return new SimpleSeries(_elt.getDate(), _elt.getWind(), _elt.get_origin());
		}).collect(Collectors.toList());
	}

	@GetMapping("mean/wind/{apiaryId}/{start}/{end}")
	public long getWindMeanValueByApiary(@PathVariable String apiaryId, @PathVariable long start, @PathVariable long end){
		long sumValue;
		List<CurrentDailyWeather> weather = this.dailyWearherRepository.findByApiaryIdAndDateBetween(apiaryId, new Date(start), new Date(end));
		System.out.println(weather.size());
		sumValue = weather.stream().mapToLong(_elt -> (long) _elt.getWind().get("maxSpeed")).sum();
		System.out.println(new Date(start));
		if (sumValue == 0) {
			return 0;
		} else {
			return sumValue / weather.size();
		}
	}
}
