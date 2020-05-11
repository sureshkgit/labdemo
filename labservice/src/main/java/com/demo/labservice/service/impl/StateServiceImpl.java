package com.demo.labservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.labservice.repository.StateRepository;
import com.demo.labservice.repository.entity.State;
import com.demo.labservice.service.StateService;

@Service
public class StateServiceImpl implements StateService {
	
	@Autowired
	private StateRepository stateRepository;

	@Override
	public List<State> findAll() {
		return stateRepository.findAll();
	}

	@Override
	public List<State> findByCountryId(Long countryId) {
		return stateRepository.findByCountryId(countryId);
	}
	
}
