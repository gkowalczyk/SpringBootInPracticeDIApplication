package com.javappa.springbootmp.service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class FileService {

	private static final Logger LOG = LoggerFactory.getLogger(FileService.class);
	
    @Value("classpath:/data/resourceSample.txt")
    Resource resourceTestFile;
   	
	@EventListener
	public void onApplicationStart(ApplicationReadyEvent event) {
		LOG.info("Reading file injected by @Value:");				
		try (Stream<String> stream = Files.lines(resourceTestFile.getFile().toPath())) {
			stream.forEach(LOG::info);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}		
	}
}
