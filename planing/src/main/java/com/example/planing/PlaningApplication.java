package com.example.planing;

import com.example.planing.bus.Bus;
import com.example.planing.bus.BusRepository;
import com.example.planing.trip.Trip;
import com.example.planing.trip.TripRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
@AllArgsConstructor
public class PlaningApplication implements CommandLineRunner {

	TripRepository tripRepository;
	BusRepository busRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlaningApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		tripRepository.deleteAll();

		tripRepository.save(
				new Trip(
						new ObjectId("1"),
						LocalDate.now(),
						LocalTime.now(),
						"alger",
						"constantine",
						new BigDecimal(800),
						0,
						null));

		busRepository.save(
				new Bus(new ObjectId("1"), 5, "morad"));

		Bus b1 = busRepository.findById(new ObjectId("1")).orElse(null);

		Trip t1 = tripRepository.findById(new ObjectId("1"))
				.orElse(null);

		if (b1 == null) {
			System.out.println("bus not found");
			return;
		}
		if (t1 == null) {
			System.out.println("trip not found");
			return;
		}

		t1.setBusId(b1.getId());
		tripRepository.save(t1);

		System.out.println(b1);
		System.out.println(t1);

	}
}
