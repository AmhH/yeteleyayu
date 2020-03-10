package com.hackerrank.user.repository;

import java.util.List;

import com.hackerrank.user.controller.CreatedResponse;
import com.hackerrank.user.model.User;

public interface UserRepository {
	List<User> getAllUsers();

	User getUserById(Integer userId);

    CreatedResponse addNewUser(User user);

	int updateUser(User user);

	int deleteUserById(Integer userId);
}
