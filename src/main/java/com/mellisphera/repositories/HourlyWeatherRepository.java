package com.mellisphera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.weather.HourlyWeather;

public interface HourlyWeatherRepository extends MongoRepository<HourlyWeather,String>{

}
