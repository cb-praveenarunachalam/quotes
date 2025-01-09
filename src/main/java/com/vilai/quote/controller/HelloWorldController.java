package com.vilai.quote.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"https://3b91-14-142-185-230.ngrok-free.app", "http://10.2.236.142:5173"}, allowedHeaders = "*", methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowCredentials = "true")
public class HelloWorldController {

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello, World!";
	}
}
