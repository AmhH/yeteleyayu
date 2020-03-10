package com.hackerrank.user.persistence.user.manager;

import java.util.List;

import com.hackerrank.user.controller.CreatedResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hackerrank.user.model.User;
import com.hackerrank.user.persistence.user.dao.UserDao;
import com.hackerrank.user.persistence.user.session.ReadWriteUserSessionFactory;
import com.hackerrank.user.repository.UserRepository;

@Repository
public class UserManager implements UserRepository {

	private final UserDao userDao;

	private final ReadWriteUserSessionFactory readWriteUserSessionFactory;

	@Autowired
	public UserManager(UserDao userDao, ReadWriteUserSessionFactory readWriteUserSessionFactory) {
		this.userDao = userDao;
		this.readWriteUserSessionFactory = readWriteUserSessionFactory;
	}

	@Override
	public List<User> getAllUsers() {
		try (SqlSession session = readWriteUserSessionFactory.openSession()) {
			return userDao.selectAllUsers(session);
		}
	}

	@Override
	public User getUserById(Integer userId) {
		try (SqlSession session = readWriteUserSessionFactory.openSession()) {
			return userDao.getUser(session, userId);
		}
	}

	@Override
	public CreatedResponse addNewUser(User user) {
		try (SqlSession session = readWriteUserSessionFactory.openSession()) {
			return userDao.addNewUser(session, user);
		}
	}

	@Override
	public int updateUser(User user) {
		try (SqlSession session = readWriteUserSessionFactory.openSession()) {
			return userDao.updateUser(session, user);
		}
	}

	@Override
	public int deleteUserById(Integer userId) {
		try (SqlSession session = readWriteUserSessionFactory.openSession()) {
			return userDao.deleteUserById(session, userId);
		}
	}
}
