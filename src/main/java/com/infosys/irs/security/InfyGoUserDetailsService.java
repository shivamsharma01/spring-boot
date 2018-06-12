package com.infosys.irs.security;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infosys.irs.entity.UserEntity;
import com.infosys.irs.model.User;
import com.infosys.irs.repository.UserRepository;

@Service
public class InfyGoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.getOne(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException(username);
		}
		User user = new User();
		user.setUserId(userEntity.getUserId());
		user.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		user.setName(userEntity.getName());
		@SuppressWarnings("unchecked")
		List<String> userRoles = (List<String>) (Object) Arrays.asList("USER");
		return new InfyGoUserDetails(userRoles, user);
	}

}
