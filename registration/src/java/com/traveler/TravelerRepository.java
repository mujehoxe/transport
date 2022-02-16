package com.traveler;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TravelerRepository extends MongoRepository<Traveler, ObjectId> {
}
