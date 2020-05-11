package com.demo.labservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.labservice.dto.CountryDto;
import com.demo.labservice.repository.entity.Country;
import com.demo.labservice.repository.entity.State;
import com.demo.labservice.service.CountryService;
import com.demo.labservice.service.StateService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api/country"})
public class CountryController {
	
	@Autowired
	private CountryService countryServiceImpl;
	
	@Autowired
	private StateService stateServiceImpl;
	
	@GetMapping
	public ResponseEntity<List<CountryDto> > getAll() {
		return ResponseEntity.ok().body(countryServiceImpl.findAll());
	}
	
	@GetMapping({"/{id}"})
	public ResponseEntity<Country> getById(@PathVariable("id")  Long id) {
		Optional<Country> optCountry = countryServiceImpl.findById(id);
		return ResponseEntity.ok().body(optCountry.get());
	}
	
	@GetMapping({"stateByCountryId/{countryId}"})
	public ResponseEntity<List<State>> getStateByCountryId(@PathVariable("countryId")  Long countryId) {
		List<State> statesList = stateServiceImpl.findByCountryId(countryId);
		return ResponseEntity.ok().body(statesList);
	}
	
}