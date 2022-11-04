package com.javappa.springbootmp.controller.qualifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import com.javappa.springbootmp.service.PrinterService;

@Controller
public class UserPrinterController {

    private static final Logger LOG = LoggerFactory.getLogger(UserPrinterController.class);
	
    @Autowired
    @Qualifier("userServicePrinterable")
    private PrinterService printerService;
    
	@EventListener
	public void onApplicationStart(ApplicationReadyEvent event) {
		LOG.info("============================ userServicePrinterable ============================");
		LOG.info(UserPrinterController.class.getName());
		printerService.printName();
		LOG.info("============================");
	}    
}
