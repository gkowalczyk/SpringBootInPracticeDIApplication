package com.javappa.springbootmp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.javappa.springbootmp.configuration.NonSpringComponentByMultipleNames;

@Service
public class ExtraItemServiceMultipleNames {

	private static final Logger LOG = LoggerFactory.getLogger(ExtraItemServiceMultipleNames.class);

	private NonSpringComponentByMultipleNames nonSpringComponentByMultipleNames;
	
	public ExtraItemServiceMultipleNames(@Qualifier("secondNonSpringBean") NonSpringComponentByMultipleNames nonSpringComponentByMultipleNames) {
		this.nonSpringComponentByMultipleNames = nonSpringComponentByMultipleNames;
	}
	
	@EventListener
	public void onApplicationStart(ApplicationReadyEvent event) {
		LOG.info("ExtraItemServiceMultipleNames!");
		LOG.info(nonSpringComponentByMultipleNames.getClass().getName());
	}
}
