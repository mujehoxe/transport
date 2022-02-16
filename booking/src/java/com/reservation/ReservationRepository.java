package com.reservation;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ReservationRepository
		extends MongoRepository<Reservation, ObjectId> {
	List<Reservation> findByTravelerId(ObjectId travelerId);
}
