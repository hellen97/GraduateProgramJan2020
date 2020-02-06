package com.mastek.hrapp.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

	@Component
	@Scope("Singleton")
	
public class ProjectService {
		String exampleProperty;
		
	public ProjectService(){
		System.out.println("Project Service Created");
	}
	@PostConstruct
		public void initializeService() {
		System.out.println("Project Service Initialized");
		
	}
	@PreDestroy
		public void terminateService() {
		System.out.println("Project Service Terminated");
	}
	public void exampleMethod() {
		System.out.println("Connect to "+getExampleProperty()+" for business data");
	
}
	public String getExampleProperty() {
		return exampleProperty;
	
}
@Value ("Spring Example Data Source")
	public void setExampleProperty(String exampleProperty) {
		System.out.println("Example property set:"+exampleProperty );
			this.exampleProperty=exampleProperty;
}
	}


