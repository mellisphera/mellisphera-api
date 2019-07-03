package com.mellisphera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.CurrentHourlyWeather;


public interface CurrentHourlyWeatherRepository extends MongoRepository<CurrentHourlyWeather ,String>{

}
