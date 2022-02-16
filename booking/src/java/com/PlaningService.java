package com;

import com.core.Trip;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "planing")
public interface PlaningService {

	@GetMapping("/trips/{id}")
	public Trip findTripById(@PathVariable ObjectId id);

}
