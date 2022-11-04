package com.javappa.springbootmp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("userServicePrinterable")
public class UserService implements PrinterService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Override
	public void printName() {
		LOG.info("UserService");
	}
}
