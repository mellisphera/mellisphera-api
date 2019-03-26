package com.mellisphera.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mellisphera.weather.WeatherAPI;

@Service
@Repository
public interface WeatherAPIRepository extends MongoRepository<WeatherAPI,String> {

	
	
}
