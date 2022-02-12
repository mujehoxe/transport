package com.example.authentication.service;

import com.example.authentication.user.AppUser;
import com.example.authentication.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
	private UserRepository userRepository;
	private PasswordEncoder bCryptPasswordEncoder;

	@Override
	public AppUser saveUser(String username, String email, String password) {
		String hash = bCryptPasswordEncoder.encode(password);
		
		AppUser user = new AppUser(username, email, hash);
		return userRepository.save(user);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser user = userRepository.findFirstByUsernameOrEmail(username, username);
		user.getRoles().add(roleName);
		userRepository.save(user);
	}

	@Override
	public AppUser findUserByUserNameOrEmail(String username) {
		return userRepository.findFirstByUsernameOrEmail(username, username);
	}

}
