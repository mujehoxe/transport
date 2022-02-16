package com.service;

import com.user.AppUser;
import com.user.UserDto;

public interface AccountService {
	public AppUser saveUser(String username, String email, String password);
	public AppUser registerNewUserAccount(UserDto userDto);
	public void addRoleToUser(String username, String roleName);
	public AppUser findUserByUserNameOrEmail(String username);
}
