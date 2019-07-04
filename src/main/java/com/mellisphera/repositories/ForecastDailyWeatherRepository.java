package com.mellisphera.repositories;

import java.util.Date;
import java.util.List;

import com.mellisphera.entities.ForecastDailyWeather;


public interface ForecastDailyWeatherRepository {

	public List<ForecastDailyWeather> findByIdApiaryAndDateBetween(String idApiary, Date start, Date end);

}
