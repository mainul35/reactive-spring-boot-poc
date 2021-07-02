package com.mainul35.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@Controller
public class HelloController {
	
	Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	
	@GetMapping({"", "/"})
	public Mono<String> hello(final Model model) {
		LOGGER.info("======== In Hello controller ========");
		model.addAttribute("message", "Hello from reactive controller");
        return Mono.just("hello");
    }

}
