package com.example.authentication;

import com.example.authentication.service.AccountService;
import com.example.authentication.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@SpringBootApplication
@AllArgsConstructor
public class AuthenticationApplication implements CommandLineRunner {

	AccountService accountService;
	UserRepository userRepository;

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
