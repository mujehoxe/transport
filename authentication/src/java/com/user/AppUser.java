package com.user;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class AppUser {

	@MongoId
	private ObjectId id;

	@NonNull
	@Indexed(unique = true)
	private String username;

	@NonNull
	@Indexed(unique = true)
	private String email;

	@NonNull
	private String password;

	private Set<String> roles = new HashSet<>();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AppUser appUser = (AppUser) o;
		return Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, password);
	}

}
