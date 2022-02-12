package com.example.booking.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Traveler {

	private ObjectId id;
	private String firstName;
	private String lastName;

}
