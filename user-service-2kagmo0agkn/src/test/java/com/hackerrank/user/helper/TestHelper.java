package com.hackerrank.user.helper;
import com.hackerrank.user.model.User;

public class TestHelper {
	public static boolean UserEquals(User expected, User actual) {
		return expected.getEmail().equals(actual.getEmail())
				&& expected.getName().equals(actual.getName())
				&& expected.getPhone().equals(actual.getPhone())
				&& expected.getUsername().equals(actual.getUsername())
				&& expected.getWebsite().equals(actual.getWebsite());
	}
}
