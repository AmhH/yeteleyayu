package com.hackerrank.user.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.user.controller.CreatedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackerrank.user.model.User;
import com.hackerrank.user.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final UserClient userClient;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, UserClient userClient) {
		this.userRepository = userRepository;
		this.userClient = userClient;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepository.getUserById(userId);
	}

	@Override
	public CreatedResponse addNewUser(User user) {
		List<User> placeHolder = userClient.getUserFromPlaceholder(user.getUsername());

		if(null != placeHolder && !placeHolder.isEmpty() && null != placeHolder.get(0))
			return userRepository.addNewUser(placeHolder.get(0));
		return userRepository.addNewUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userRepository.updateUser(user);
	}

	@Override
	public int deleteUserById(Integer userId) {
		return userRepository.deleteUserById(userId);
	}
}
