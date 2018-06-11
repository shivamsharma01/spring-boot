package com.infosys.irs.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.irs.entity.UserEntity;
import com.infosys.irs.exception.InvalidCityException;
import com.infosys.irs.exception.InvalidEmailException;
import com.infosys.irs.exception.InvalidNameException;
import com.infosys.irs.exception.InvalidPasswordException;
import com.infosys.irs.exception.InvalidPhoneException;
import com.infosys.irs.exception.InvalidUserIdException;
import com.infosys.irs.exception.UserIdAlreadyPresentException;
import com.infosys.irs.model.User;
import com.infosys.irs.repository.UserRepository;

@Service
public class RegistrationService {
	@Autowired
	private UserRepository userRepository;

	public String registerUser(User user) throws UserIdAlreadyPresentException {
		if (userRepository.existsById(user.getUserId())) {
			throw new UserIdAlreadyPresentException("RegistrationService.USERID_PRESENT");
		}
		UserEntity uEntity = new UserEntity();
		uEntity.setUserId(user.getUserId());
		uEntity.setPassword(user.getPassword());
		uEntity.setName(user.getName());
		uEntity.setCity(user.getCity());
		uEntity.setEmail(user.getEmail());
		uEntity.setPhone(user.getPhone());
		userRepository.saveAndFlush(uEntity);
		return "UserRepository.REGISTRATION_SUCCESS";
	}

}
