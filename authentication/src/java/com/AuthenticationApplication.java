package com;

import com.service.AccountService;
import com.user.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
@EnableFeignClients
public class AuthenticationApplication implements CommandLineRunner {

//	AccountService accountService;
//	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();

		accountService.saveUser("user", "user@example.com", "user");
		accountService.saveUser("admin", "admin@example.com","admin");

		accountService.addRoleToUser("user", "USER");
		accountService.addRoleToUser("user", "USER");
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
	}

}
