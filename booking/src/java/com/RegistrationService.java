package com;

import com.core.Traveler;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "registration")
public interface RegistrationService {

	@GetMapping("/travelers/{id}")
	Traveler findTravelerById(@PathVariable ObjectId id);

}
