package sai.springpoc.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	private static boolean available;

	public AppController(Environment environment) {
		// will read the VM arg passed as -Davailabile=true and returns the value, 
		// in case if the VM arg is not passed, then defaults to false
		available = Boolean.valueOf(environment.getProperty("available", "false"));
	}

	@GetMapping("/checkAvailability")
	public Boolean isAvailable() {
		return available;
	}
}
