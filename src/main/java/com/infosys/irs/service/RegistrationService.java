package com.infosys.irs.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.irs.exception.InvalidCityException;
import com.infosys.irs.exception.InvalidEmailException;
import com.infosys.irs.exception.InvalidNameException;
import com.infosys.irs.exception.InvalidPasswordException;
import com.infosys.irs.exception.InvalidPhoneException;
import com.infosys.irs.exception.InvalidUserIdException;
import com.infosys.irs.model.User;
import com.infosys.irs.repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository userRepository;

	public String registerUser(User user) throws Exception {
		validateUser(user);
		return userRepository.registerUser(user);
	}

	private void validateUser(User user) throws Exception {
		if (!isValidUserId(user.getUserId())) {
			System.out.println("Invalid userid");
			throw new InvalidUserIdException("RegistrationService.INVALID_USER_ID");
		}
		if (!isValidPassword(user.getPassword())) {
			System.out.println("Invalid pass");
			throw new InvalidPasswordException("RegistrationService.INVALID_PASSWORD");
		}
		if (!isValidName(user.getName())) {
			System.out.println("Invalid name");
			throw new InvalidNameException("RegistrationService.INVALID_NAME");
		}
		if (!isValidCity(user.getCity())) {
			System.out.println("Invalid city");
			throw new InvalidCityException("RegistrationService.INVALID_CITY");
		}
		if (!isValidEmail(user.getEmail())) {
			System.out.println("Invalid email");
			throw new InvalidEmailException("RegistrationService.INVALID_EMAIL");
		}
		if (!isValidPhoneNumber(user.getPhone())) {
			System.out.println("Invalid phone");
			throw new InvalidPhoneException("RegistrationService.INVALID_PHONE_NUMBER");
		}
	}

	public Boolean isValidUserId(String userid) {
		String regex = "^[a-zA-Z0-9]{4,15}+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(userid);
		return matcher.matches();
	}

	public Boolean isValidPassword(String password) {
		String regex = "^[a-zA-Z0-9]{8,15}+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	public Boolean isValidName(String name) {
		String regex = "^[a-zA-Z0-9]{4,15}+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

	public Boolean isValidCity(String city) {
		String regex = "^[a-zA-Z0-9]{4,15}+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(city);
		return matcher.matches();
	}

	public Boolean isValidEmail(String email) {
		String regex = "^[a-zA-Z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public Boolean isValidPhoneNumber(String phoneNumber) {
		String regex = "^[0-9]{10}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		return matcher.matches();
	}

}
