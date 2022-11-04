package com.javappa.springbootmp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.javappa.springbootmp.configuration.NonSpringComponent;

@Service("itemServicePrinterable")
public class ItemService implements PrinterService {

	private static final Logger LOG = LoggerFactory.getLogger(ItemService.class);
		
	private NonSpringComponent nonSpringComponent;
	
	public ItemService(NonSpringComponent nonSpringComponent) {
		this.nonSpringComponent = nonSpringComponent;
	}
	
	@Override
	public void printName() {	
		LOG.info("ItemService");
		LOG.info("============================");
		LOG.info("NonSpringComponent injection proove:");
		LOG.info(nonSpringComponent.getContent());
	}
}
