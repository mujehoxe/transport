package com.example.planing.trip;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

	@MongoId(FieldType.OBJECT_ID)
	private ObjectId id;

	private LocalDate date;
	private LocalTime time;
	private String departure;
	private String destination;
	private BigDecimal price;
	private Integer reservedSeatsNumber;

	@Field(targetType = FieldType.OBJECT_ID)
	private ObjectId busId;

}
