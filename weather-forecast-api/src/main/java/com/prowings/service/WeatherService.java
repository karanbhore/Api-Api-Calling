package com.prowings.service;

import org.springframework.http.ResponseEntity;

import com.prowings.model.Weather;
import com.prowings.model.dto.Climate;

import reactor.core.publisher.Mono;

public interface WeatherService {
	

	public Mono<Climate> createWeather(Weather weather); 

	public Mono<Climate> getWeatherByCity(String city); 

}
