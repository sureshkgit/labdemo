package com.demo.labservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class HomeController {
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Value("${app.name}")
	private String appName;
    
    @GetMapping
    public ResponseEntity<String> getWelcomeMessage(){
    	log.info("*** {} -> {} *****" , appName, welcomeMessage);
        return ResponseEntity.status(HttpStatus.OK).body(welcomeMessage);
    }
	@GetMapping({"test"})
	public ResponseEntity<List<String>> getHome() {
		List<String> response = new ArrayList<String>();
		response.add(appName + " Test Message1**");
		response.add(appName + " Test Message2**");

		return ResponseEntity.ok().body(response);
	}
}