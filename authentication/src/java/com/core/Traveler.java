package com.core;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Traveler {

  @JsonSerialize(using = ToStringSerializer.class)
  private ObjectId id;
	private String firstName;
	private String lastName;

}
