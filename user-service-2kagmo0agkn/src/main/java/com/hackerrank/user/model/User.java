package com.hackerrank.user.model;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	public static User buildUser(HashMap data) {
		if (data == null) {
			return null;
		}

		return User.builder()
				.id((Integer) data.get("id"))
				.name((String) data.get("name"))
				.username((String) data.get("username"))
				.email((String) data.get("email"))
				.phone((String) data.get("phone"))
				.website((String) data.get("website"))
				.build();
	}

	private Integer id;

	private String name;

	private String username;

	private String email;

	private String phone;

	private String website;
}
