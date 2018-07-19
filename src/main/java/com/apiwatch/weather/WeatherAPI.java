package com.apiwatch.weather;

import java.util.List;

public class WeatherAPI {
	
	public _Coord coord;
	public List<_Weather> weather;
	public _Main main;
	public _Wind wind;
	public long id;
	public String name;
	public _Sys sys;
	
	public WeatherAPI() {
		super();
	}

	public WeatherAPI(_Coord coord, List<_Weather> weather, _Main main, _Wind wind, long id, String name, _Sys sys) {
		super();
		this.coord = coord;
		this.weather = weather;
		this.main = main;
		this.wind = wind;
		this.id = id;
		this.name = name;
		this.sys = sys;
	}

	public _Coord getCoord() {
		return coord;
	}

	public void setCoord(_Coord coord) {
		this.coord = coord;
	}

	public List<_Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<_Weather> weather) {
		this.weather = weather;
	}

	public _Main getMain() {
		return main;
	}

	public void setMain(_Main main) {
		this.main = main;
	}

	public _Wind getWind() {
		return wind;
	}

	public void setWind(_Wind wind) {
		this.wind = wind;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public _Sys getSys() {
		return sys;
	}

	public void setSys(_Sys sys) {
		this.sys = sys;
	}
	
	
	
	
	
}
