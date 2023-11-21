package com.prowings.service;

import com.prowings.entity.Climate;

public interface ClimateService {
	
	public Climate createClimate(Climate climate);

	public Climate getClimateByCity(String city);
	
}
