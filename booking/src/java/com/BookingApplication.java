package com;

import java.util.List;

import com.reservation.Reservation;
import com.reservation.ReservationService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableFeignClients
@AllArgsConstructor
public class BookingApplication implements CommandLineRunner {

  private ReservationService reservationService;

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		reservationService.deleteAll();

		String id = "6209720897e1c14b02dd7433";

		reservationService.save(id, id);

    List<Reservation> reservations =
		    reservationService.findAllByTravelerId(id);
		reservations.forEach(reservation -> System.out.println(reservation));
	}

}

