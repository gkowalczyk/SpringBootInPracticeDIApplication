package com.javappa.springbootmp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.javappa.springbootmp.configuration.NonSpringComponentByName;

@Service
public class ExtraItemService {

	private static final Logger LOG = LoggerFactory.getLogger(ExtraItemService.class);

	private NonSpringComponentByName nonSpringComponentByName;
	
	public ExtraItemService(@Qualifier("nonSpringBean") NonSpringComponentByName nonSpringComponentByName) {
		this.nonSpringComponentByName = nonSpringComponentByName;
	}
	
	@EventListener
	public void onApplicationStart(ApplicationReadyEvent event) {
		LOG.info("ExtraItemService!");
		LOG.info(nonSpringComponentByName.getClass().getName());
	}
}
