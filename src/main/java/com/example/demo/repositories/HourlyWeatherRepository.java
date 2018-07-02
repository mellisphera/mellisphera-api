package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.entities.weather.HourlyWeather;

public interface HourlyWeatherRepository extends MongoRepository<HourlyWeather,String>{

}
