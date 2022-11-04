package com.javappa.springbootmp.controller.autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import com.javappa.springbootmp.service.ItemService;

@Controller
public class ItemControllerAutowireHiddenByConstructor {

	private static final Logger LOG = LoggerFactory.getLogger(ItemControllerAutowireHiddenByConstructor.class);
	
	private ItemService itemService;
	
	public ItemControllerAutowireHiddenByConstructor(ItemService itemService) {
		this.itemService = itemService;	
	}
	
	@EventListener
	public void onApplicationStart(ApplicationReadyEvent event) {
		LOG.info("Autowiring hidden by constructor: ");
		LOG.info(itemService.getClass().getName());
	}
}
