package com.example.booking;

import com.example.booking.core.Traveler;
import com.example.booking.core.Trip;
import com.example.booking.reservation.Reservation;
import com.example.booking.reservation.Reservation.ReservationId;
import com.example.booking.reservation.ReservationRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@AllArgsConstructor
public class BookingApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		reservationRepository.deleteAll();

		Trip trip1 = planingService.findTripById(new ObjectId("1"));
		System.out.println(trip1);

		Traveler traveler1 = registrationService.findTravelerById(
				new ObjectId("1"));
		System.out.println(traveler1);

		Reservation r1 = reservationRepository.save(
				new Reservation(
						new ReservationId(trip1.getId(), traveler1.getId())));

	}

	private ReservationRepository reservationRepository;
	private PlaningService planingService;

	private PlaningService registrationService;

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}
}
