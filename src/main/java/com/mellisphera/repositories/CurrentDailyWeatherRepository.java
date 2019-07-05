package com.mellisphera.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.CurrentDailyWeather;


public interface CurrentDailyWeatherRepository extends MongoRepository<CurrentDailyWeather ,String> {

	public List<CurrentDailyWeather> findByIdApiaryAndDateBetween(String idApiary, Date start, Date end);
}
