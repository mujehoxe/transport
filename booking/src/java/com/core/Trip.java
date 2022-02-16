package com.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trip {

	private LocalDate date;
	private LocalTime time;
	private String departure;
	private String destination;
	private BigDecimal price;

  @JsonSerialize(using = ToStringSerializer.class)
	private ObjectId busId;

}
