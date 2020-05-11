package com.demo.labservice.service;

import java.util.List;
import java.util.Optional;

import com.demo.labservice.dto.CountryDto;
import com.demo.labservice.repository.entity.Country;

public interface CountryService {

    List<CountryDto> findAll();
    Optional<Country> findById(Long id);
}
