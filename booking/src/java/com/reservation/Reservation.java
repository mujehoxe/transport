package com.reservation;

import java.time.LocalDateTime;

import com.core.Traveler;
import com.core.Trip;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document
@Data
@RequiredArgsConstructor
public class Reservation {

	@NonNull
  @JsonSerialize(using = ToStringSerializer.class)
 	private ObjectId tripId;

	@NonNull
  @JsonSerialize(using = ToStringSerializer.class)
	private ObjectId travelerId;

  private LocalDateTime createdOn = LocalDateTime.now();

	@Transient
	private Trip trip;

	@Transient
	private Traveler traveler;

}
