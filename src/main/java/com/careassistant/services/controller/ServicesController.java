package com.careassistant.services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ServicesController {

	@GetMapping
	public String test() {
		return "Hola";

	}

}
