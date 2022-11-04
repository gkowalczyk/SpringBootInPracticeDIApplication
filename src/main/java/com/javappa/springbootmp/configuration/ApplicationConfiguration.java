package com.javappa.springbootmp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

	@Bean
    public NonSpringComponent nonSpringComponent() {
    	return new NonSpringComponent("I am non spring component but I can still be injected thanks to @Bean!");
    }
    
    @Bean("nonSpringBean")
    public NonSpringComponentByName nonSpringComponentByMyBean() {
    	return new NonSpringComponentByName("I can still be injected thanks to @Bean via name!");
    }    
    
    @Bean({"firstNonSpringBean", "secondNonSpringBean", "thirdNonSpringBean"})
    public NonSpringComponentByMultipleNames nonSpringComponentMultipleNames() {
    	return new NonSpringComponentByMultipleNames("I can still be injected thanks to @Bean via name multiple!");
    }        
}
