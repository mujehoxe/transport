package com.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import org.bson.types.ObjectId;

import lombok.Data;

@Data
public class UserDto {

  @JsonSerialize(using = ToStringSerializer.class)
  private ObjectId id;

  private String username;

  private String firstName;
  private String lastName;

  private String password;

  private String matchingPassword;
    
  private String email;
    
}
