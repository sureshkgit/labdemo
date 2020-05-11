package com.demo.labservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.labservice.repository.entity.State;

public interface StateRepository extends JpaRepository<State, Long> {

	List<State> findByCountryId(Long countryId);

}