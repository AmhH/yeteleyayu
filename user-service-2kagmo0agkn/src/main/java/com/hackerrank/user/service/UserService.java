package com.hackerrank.user.service;

import java.util.List;

import com.hackerrank.user.controller.CreatedResponse;
import com.hackerrank.user.model.User;

public interface UserService {
	List<User> getAllUsers();

	User getUserById(Integer userId);

    CreatedResponse addNewUser(User user);

	int updateUser(User user);

	int deleteUserById(Integer userId);
}
