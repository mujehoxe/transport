package com.example.booking.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

	private ObjectId id;
	private LocalDate date;
	private LocalTime time;
	private String departure;
	private String destination;
	private BigDecimal price;
	private ObjectId busId;

}
