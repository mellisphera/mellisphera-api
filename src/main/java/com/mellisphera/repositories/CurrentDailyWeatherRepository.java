package com.mellisphera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.CurrentDailyWeather;


public interface CurrentDailyWeatherRepository extends MongoRepository<CurrentDailyWeather ,String> {

}
