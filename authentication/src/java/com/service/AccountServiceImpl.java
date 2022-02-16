package com.service;

import com.user.AppUser;
import com.user.UserDto;
import com.user.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;@Service
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

  @Override
  public AppUser registerNewUserAccount(final UserDto accountDto) {
        //if (emailExists(accountDto.getUsername()))
        //  throw new UserAlreadyExistException("There is an account with that username: " + accountDto.getUsername());

        //if (emailExists(accountDto.getEmail())) {
        //    throw new UserAlreadyExistException("There is an account with that email address: " + accountDto.getEmail());
        //}

        final AppUser user = new AppUser();

        user.setId(accountDto.getId());
        user.setUsername(accountDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.getRoles().add("USER");

        return userRepository.save(user);
  }

  private boolean emailExists(String username) {
        return userRepository
          .findFirstByUsernameOrEmail(username, username) != null;
  }
  
}

