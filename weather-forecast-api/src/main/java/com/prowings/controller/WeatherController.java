package com.prowings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.model.Weather;
import com.prowings.model.dto.Climate;
import com.prowings.service.WeatherService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping("/v1")
public class WeatherController {

	@Autowired
	WeatherService weatherService;

	@GetMapping("/test")
	public String hello() {
		return "welcome to weather forcasting api!!";
	}

	@CircuitBreaker(name = "randomActivity", fallbackMethod = "fallbackRandomActivity")
	@GetMapping("/weathers/{city}")
	public Mono<Climate> getWeatherByCity(@PathVariable String city) {
		log.info("Request received to get weather of {} city", city);
		return weatherService.getWeatherByCity(city);

	}

	public String fallbackRandomActivity(Throwable throwable) {
		return "Watch a video from TechPrimers";
	}

	@PostMapping("/weathers")
	public Mono<Climate> predictNewWeather(@RequestBody Weather weather) {
		log.info("Request received to add weather : {} in weather api", weather);
		return weatherService.createWeather(weather);
	}
}
