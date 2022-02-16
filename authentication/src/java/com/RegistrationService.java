package com;

import com.core.Traveler;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "registration")
public interface RegistrationService {

	@PostMapping("/travelers")
	void save(@RequestBody Traveler traveler);

}
