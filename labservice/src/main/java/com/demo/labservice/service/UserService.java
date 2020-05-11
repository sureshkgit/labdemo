package com.demo.labservice.service;

import java.util.List;
import java.util.Optional;

import com.demo.labservice.dto.UserDto;
import com.demo.labservice.repository.entity.User;

public interface UserService {

    List<UserDto> findAll();
    List<UserDto> findByCountryId(Long countryId);
    List<UserDto> findByCountryIdAndStateId(Long countryId, Long stateId);
}
