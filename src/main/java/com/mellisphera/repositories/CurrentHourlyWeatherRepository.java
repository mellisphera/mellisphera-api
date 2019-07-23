package com.mellisphera.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mellisphera.entities.CurrentHourlyWeather;


public interface CurrentHourlyWeatherRepository extends MongoRepository<CurrentHourlyWeather ,String>{
	public List<CurrentHourlyWeather> findByIdApiaryAndDateBetween(String idApiary, Date start, Date end);

}
