package com.demo.labservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.labservice.dto.UserDto;
import com.demo.labservice.repository.UserRepository;
import com.demo.labservice.repository.entity.User;
import com.demo.labservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<UserDto> findAll() {
		return convertUserDtoList(userRepo.findAll());
	}
	
	@Override
	public List<UserDto> findByCountryId(Long countryId) {
		return convertUserDtoList(userRepo.findByCountryId(countryId));
	}
	
	@Override
	public List<UserDto> findByCountryIdAndStateId(Long countryId, Long stateId) {
		return convertUserDtoList(userRepo.findByCountryIdAndStateId(countryId, stateId));
	}

	/** ************ Utility Methods ** ************/
	public static List<UserDto> convertUserDtoList(List<User> userList) {
		List<UserDto> usersDtoList = userList.stream()
				.map(userObj ->  convertUserDto(userObj) )
				.collect(Collectors.toList());
		return usersDtoList;
	}
	
	public static UserDto convertUserDto(User user) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		log.info(userDto.toString());
		return userDto;
	}
	
}
