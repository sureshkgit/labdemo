package com.demo.labservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.labservice.dto.UserDto;
import com.demo.labservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/user"})
public class UserController {
	
	@Autowired
	private UserService userServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<UserDto> > getAll() {
		return ResponseEntity.ok().body(userServiceImpl.findAll());
	}

	@GetMapping({"byCountryId/{countryId}"})
	public ResponseEntity<List<UserDto>> findByCountryId(@PathVariable("countryId")  Long countryId) {
		log.info("##### User ByCountryId {}",countryId);
		return ResponseEntity.ok().body(userServiceImpl.findByCountryId(countryId));
	}
	
	@GetMapping({"byCountryStateId/{countryId}/{stateId}"})
	public ResponseEntity<List<UserDto>> getByCountryStateId(@PathVariable("countryId")  Long countryId, 
			@PathVariable("stateId")  Long stateId) {
		return ResponseEntity.ok().body(userServiceImpl.findByCountryIdAndStateId(countryId, stateId));
	}
	
}