package com.example.authentication.service;

import com.example.authentication.user.AppUser;

public interface AccountService {
	public AppUser saveUser(String username, String email, String password);
	public void addRoleToUser(String username, String roleName);
	public AppUser findUserByUserNameOrEmail(String username);
}
