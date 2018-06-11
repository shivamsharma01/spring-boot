package com.infosys.irs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.irs.entity.UserEntity;
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
