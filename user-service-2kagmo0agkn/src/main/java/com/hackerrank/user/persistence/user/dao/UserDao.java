package com.hackerrank.user.persistence.user.dao;

import com.hackerrank.user.controller.CreatedResponse;
import com.hackerrank.user.model.User;
import com.hackerrank.user.persistence.user.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDao {
	public List<User> selectAllUsers(SqlSession session) {
		UserMapper userMapper = session.getMapper(UserMapper.class);

		return userMapper.selectAllUsers().stream()
				.map(User::buildUser)
				.collect(Collectors.toList());
	}

	public User getUser(SqlSession session, Integer id) {
		UserMapper userMapper = session.getMapper(UserMapper.class);

		return userMapper.getUser(id)
				.stream()
				.map(User::buildUser)
				.findAny()
				.orElse(new User());
	}

	public CreatedResponse addNewUser(SqlSession session, User user) {
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int idCreated = userMapper.insertUser(user.getName(), user.getUsername(), user.getEmail(),
				user.getPhone(), user.getWebsite());

		CreatedResponse createdResponse = new CreatedResponse(idCreated);
		return createdResponse;

	}

	public int updateUser(SqlSession session, User user)  {
		UserMapper userMapper = session.getMapper(UserMapper.class);
		return userMapper.updateUser(user.getId(), user.getName(), user.getUsername(), user.getEmail(),
				user.getPhone(), user.getWebsite());

	}

	public int deleteUserById(SqlSession session, Integer userId) {
		UserMapper userMapper = session.getMapper(UserMapper.class);
		return userMapper.deleteUser(userId);
	}
}
