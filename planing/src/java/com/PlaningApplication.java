package com;

import com.bus.Bus;
import com.bus.BusRepository;
import com.trip.Trip;
import com.trip.TripRepository;
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
		busRepository.deleteAll();

		String id = "6209720897e1c14b02dd7433";

		tripRepository.save(
				new Trip(
						new ObjectId(id),
						LocalDate.now(),
						LocalTime.now(),
						"alger",
						"constantine",
						new BigDecimal(800),
						0,
						null));

		busRepository.save(
				new Bus(new ObjectId(id), 5, "morad"));

		Bus b1 = busRepository.findById(new ObjectId(id)).orElse(null);

		Trip t1 = tripRepository.findById(new ObjectId(id))
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
