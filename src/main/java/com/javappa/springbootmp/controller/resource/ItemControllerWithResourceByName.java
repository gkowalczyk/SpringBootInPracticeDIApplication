package com.javappa.springbootmp.controller.resource;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import com.javappa.springbootmp.service.PrinterService;

@Controller
public class ItemControllerWithResourceByName {

	private static final Logger LOG = LoggerFactory.getLogger(ItemControllerWithResourceByName.class);

	@Resource(name="itemServicePrinterable")
	private PrinterService printerService;

	@EventListener
	public void onApplicationStart(ApplicationReadyEvent event) {
		LOG.info("Injecting with @Resource by name: ");
		LOG.info(printerService.getClass().getName());
	}
}
