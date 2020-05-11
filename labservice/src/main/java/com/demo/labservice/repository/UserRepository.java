package com.demo.labservice.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.labservice.repository.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

	List<User> findByCountryId(Long id);

	List<User> findByCountryIdAndStateId(Long countryId, Long stateId);

}