package com.restservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.restservice.service.GreetingService;
import com.restservice.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class GreetingController {

	@Autowired
	private GreetingService greetingService;


	@GetMapping("/greetings")
	public List<Greeting> getGreetings() throws IOException {

		return greetingService.getAllGreeting();
	}


}
