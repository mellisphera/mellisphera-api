package com.mellisphera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.ForecastHourlyWeather;


public interface ForecastHourlyWeatherRepository extends MongoRepository<ForecastHourlyWeather ,String> {

}
