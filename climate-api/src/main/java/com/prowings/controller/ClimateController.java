package com.prowings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prowings.entity.Climate;
import com.prowings.service.ClimateService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class ClimateController {

	@Autowired
	ClimateService climateService;
	
	@PostMapping("/climates")
	public Climate createClimate(HttpEntity<String> request) throws JsonMappingException, JsonProcessingException
	{
		String body = request.getBody();
		log.info("Incoming request is : {} ", body);
		ObjectMapper mapper = new ObjectMapper();
		Climate climate = mapper.readValue(body, Climate.class);
		return climateService.createClimate(climate);
	}
	@GetMapping("/climates/{city}")
	public Climate getClimateByCity(@PathVariable String city)
	{
		return climateService.getClimateByCity(city);
	}

}
