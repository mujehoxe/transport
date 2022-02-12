package com.example.authentication.user;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository
		extends MongoRepository<AppUser, ObjectId> {
	AppUser findFirstByUsernameOrEmail(String username, String email);
}
