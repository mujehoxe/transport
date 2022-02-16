package com;

import com.traveler.Traveler;
import com.traveler.TravelerRepository;
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

		String id = "6209720897e1c14b02dd7433";
		
		Traveler t1 = travelerRepository.save(
				new Traveler(
						new ObjectId(id),
						"mohamed",
						"mohamed"));

		System.out.println(t1);

	}

}
