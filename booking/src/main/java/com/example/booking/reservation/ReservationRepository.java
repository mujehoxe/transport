package com.example.booking.reservation;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository
		extends MongoRepository<Reservation, Reservation.ReservationId> {
}
