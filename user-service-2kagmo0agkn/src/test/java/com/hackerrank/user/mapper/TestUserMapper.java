package com.hackerrank.user.mapper;
import java.util.HashMap;

public interface TestUserMapper {
	HashMap selectUserByUsername(String username);
}
