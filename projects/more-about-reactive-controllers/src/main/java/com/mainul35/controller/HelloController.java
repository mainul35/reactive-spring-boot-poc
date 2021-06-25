package com.mainul35.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController {
	
	Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping({"", "/"})
	public Mono<String> hello() {
		LOGGER.info("======== Printing an INFO Log ========");
		LOGGER.debug("======== Printing an DEBUG Log ========");
		LOGGER.warn("======== Printing an WARNING Log ========");
		LOGGER.error("======== Printing an Error Log ========");
        return Mono.just("Hello world.");
    }

}
