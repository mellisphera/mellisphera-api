package com.mellisphera.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.ForecastHourlyWeather;



public interface ForecastHourlyWeatherRepository extends MongoRepository<ForecastHourlyWeather ,String> {
	public List<ForecastHourlyWeather> findByIdApiaryAndDateBetween(String idApiary, Date start, Date end);
	
	public List<ForecastHourlyWeather> findByIdApiary(String idApiary);


}
