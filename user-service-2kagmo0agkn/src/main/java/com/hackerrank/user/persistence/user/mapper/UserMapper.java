package com.hackerrank.user.persistence.user.mapper;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
	List<HashMap> selectAllUsers();
	List<HashMap> getUser(Integer id);
	int insertUser(String name, String username, String email, String phone,
							 String website);
	int updateUser(Integer id, String name, String username, String email, String phone,
							 String website);
	int deleteUser(Integer id);
}
