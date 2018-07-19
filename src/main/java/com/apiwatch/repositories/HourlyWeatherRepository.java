package com.apiwatch.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apiwatch.weather.HourlyWeather;

public interface HourlyWeatherRepository extends MongoRepository<HourlyWeather,String>{

}
