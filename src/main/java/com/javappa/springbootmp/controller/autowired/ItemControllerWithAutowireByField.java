package com.javappa.springbootmp.controller.autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import com.javappa.springbootmp.service.ItemService;

@Controller
public class ItemControllerWithAutowireByField {

	private static final Logger LOG = LoggerFactory.getLogger(ItemControllerWithAutowireByField.class);
	
	@Autowired
	private ItemService itemService;
		
	public ItemControllerWithAutowireByField(ItemService itemService) {
		this.itemService = itemService;	
	}
	
	@EventListener
	public void onApplicationStart(ApplicationReadyEvent event) {
		LOG.info("Autowiring by field: ");
		LOG.info(itemService.getClass().getName());
	}	
}
