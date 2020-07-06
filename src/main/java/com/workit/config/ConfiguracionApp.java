package com.workit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.workit.beans.FilterApp;

@Configuration
public class ConfiguracionApp {
	
	@Bean
	public FilterApp filterApp() {	 
		return new FilterApp();
	}
	
}
