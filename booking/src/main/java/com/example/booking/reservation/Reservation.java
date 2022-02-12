package com.example.booking.reservation;

import com.example.booking.core.Traveler;
import com.example.booking.core.Trip;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Reservation {

	@MongoId
	@NonNull
	private ReservationId reservationId;

	@Transient
	private Trip trip;

	@Transient
	private Traveler traveler;

	@AllArgsConstructor
	public static class ReservationId {
		private ObjectId tripId;
		private ObjectId travelerId;
	}

}
