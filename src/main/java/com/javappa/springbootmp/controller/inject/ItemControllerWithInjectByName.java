package com.javappa.springbootmp.controller.inject;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import com.javappa.springbootmp.service.PrinterService;

@Controller
public class ItemControllerWithInjectByName {

	private static final Logger LOG = LoggerFactory.getLogger(ItemControllerWithInjectByName.class);

	@Inject
	@Named("itemServicePrinterable")
	private PrinterService printerService;

	@EventListener
	public void onApplicationStart(ApplicationReadyEvent event) {
		LOG.info("Injecting with @Inject by name: ");
		LOG.info(printerService.getClass().getName());
	}
}
