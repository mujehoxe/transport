package com.example.booking;

import com.example.booking.core.Traveler;
import com.example.booking.core.Trip;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient
public interface PlaningService {

	@GetMapping("/trips/{id}")
	public Trip findTripById(@PathVariable ObjectId id);

	@GetMapping("/travelers/{id}")
	Traveler findTravelerById(@PathVariable ObjectId id);

}