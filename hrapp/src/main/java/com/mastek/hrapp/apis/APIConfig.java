package com.mastek.hrapp.apis;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastek.hrapp.services.EmployeeService;

@Component//declare it is a spring component
public class APIConfig
		extends ResourceConfig{
	//configure the service classes using ResourceConfig
	
	public APIConfig() {
		//register each service class to enable services as API
		register(EmployeeService.class);
	}

}
