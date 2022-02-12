package com.example.registration;

import com.example.registration.traveler.Traveler;
import com.example.registration.traveler.TravelerRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class RegistrationApplication implements CommandLineRunner {

	TravelerRepository travelerRepository;

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		travelerRepository.deleteAll();

		Traveler t1 = travelerRepository.save(
				new Traveler(
						new ObjectId("1"),
						"mohamed",
						"mohamed"));

		System.out.println(t1);

	}

}
