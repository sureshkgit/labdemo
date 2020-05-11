package com.demo.labservice.service;

import java.util.List;

import com.demo.labservice.repository.entity.State;

public interface StateService {

    List<State> findAll();
    List<State> findByCountryId(Long countryId);
    
}