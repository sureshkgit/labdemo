package com.demo.labservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.labservice.dto.CountryDto;
import com.demo.labservice.repository.CountryRepository;
import com.demo.labservice.repository.entity.Country;
import com.demo.labservice.service.CountryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<CountryDto> findAll() {
		return convertCountryDtoList(countryRepository.findAll());
	}

	@Override
	public Optional<Country> findById(Long id) {
		return countryRepository.findById(id);
	}
	
	/** ************ Utility Methods ** ************/
	public static List<CountryDto> convertCountryDtoList(List<Country> countryList) {
		List<CountryDto> dtoList = countryList.stream()
				.map(obj ->  convertCountryDtoList(obj))
				.collect(Collectors.toList());
		return dtoList;
	}
	
	public static CountryDto convertCountryDtoList(Country country) {
		CountryDto countryDto = new CountryDto();
		BeanUtils.copyProperties(country, countryDto);
		log.info(countryDto.toString());
		return countryDto;
	}

}
