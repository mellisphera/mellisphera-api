package com.mellisphera.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.ForecastDailyWeather;


public interface ForecastDailyWeatherRepository extends MongoRepository<ForecastDailyWeather ,String> {
	public List<ForecastDailyWeather> findByIdApiaryAndDateBetween(String idApiary, Date start, Date end);

}
