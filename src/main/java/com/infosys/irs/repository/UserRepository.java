package com.infosys.irs.repository;

import org.springframework.stereotype.Component;

import com.infosys.irs.model.User;

@Component
public class UserRepository {

	public String registerUser(User user) {
		return "UserRepository.REGISTRATION_SUCCESS";
	}
}
