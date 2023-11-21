package com.prowings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.entity.Climate;
import com.prowings.repository.ClimateRepository;

@Service
public class ClimateServiceImpl implements ClimateService{
	
	@Autowired
	ClimateRepository climaterepo;

	@Override
	public Climate createClimate(Climate climate) {
		return climaterepo.save(climate);
	}

	@Override
	public Climate getClimateByCity(String city) {
		return climaterepo.findByCity(city);
	}

}
