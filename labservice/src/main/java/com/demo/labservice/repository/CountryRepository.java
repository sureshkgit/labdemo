package com.demo.labservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.labservice.repository.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	Country findByCountryName(String countryName);
}