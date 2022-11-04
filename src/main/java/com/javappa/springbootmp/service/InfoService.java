package com.javappa.springbootmp.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class InfoService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ItemService.class);
	
    @Value("${application.alternative.name}")
    String appAlternativeName;
    
    @Value("${testEnvValfue?:some default value}")
    private String testEnvValue;
       	
    @Value("${applicationValues}")
    private String[] applicationValues;    
    
    
	@EventListener
	public void onApplicationStart(ApplicationReadyEvent event) {
		LOG.info("Reading from application.properties using @Value:");				
		LOG.info(appAlternativeName);
		LOG.info(testEnvValue);
		Arrays.asList(applicationValues).stream().forEach(LOG::info);
	}    
}
