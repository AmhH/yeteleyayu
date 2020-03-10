package com.hackerrank.user;

import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.user.controller.CreatedResponse;
import com.hackerrank.user.helper.TestHelper;
import com.hackerrank.user.mapper.TestUserMapper;
import com.hackerrank.user.model.User;
import com.hackerrank.user.persistence.user.session.ReadWriteUserSessionFactory;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = Application.class)
public class ApplicationTest {
	protected static HttpHeaders httpHeaders;

	private static ObjectMapper objectMapper;

	@BeforeClass
	public static void setup() {
		httpHeaders = new HttpHeaders();
		httpHeaders.add("Accept", "application/json");

		objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	@Autowired
	private ReadWriteUserSessionFactory readWriteUserSessionFactory;

	@Autowired
	protected MockMvc mvc;

	@Autowired
	protected MockMvc mockMvc;

	@Test
	public void testGetUser() throws Exception {
		String response = mvc
				.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON).headers(httpHeaders))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andReturn().getResponse().getContentAsString();

		User user = new ObjectMapper().readValue(response, User.class);

		User expected = objectMapper.readValue("{\n" +
						"  \"id\": 1,\n" +
						"  \"name\": \"Phil Philips\",\n" +
						"  \"username\": \"phil123\",\n" +
						"  \"email\": \"phil@philips.com\",\n" +
						"  \"phone\": \"555-555-5555\",\n" +
						"  \"website\": \"philps.com\"\n" +
						"}",
				User.class);

		assertTrue(TestHelper.UserEquals(expected, user));
	}

	@Test
	public void testUserCreation() throws Exception {
		String newUser = "{\n" +
				"  \"name\": \"Jimmy Jameson\",\n" +
				"  \"username\": \"jimmy123\",\n" +
				"  \"email\": \"jimmy@jameson.com\",\n" +
				"  \"phone\": \"555-555-5555\",\n" +
				"  \"website\": \"jimmy.com\"\n" +
				"}";

		mvc.perform(post("/user")
				.content(newUser)
				.contentType(MediaType.APPLICATION_JSON).headers(httpHeaders))
				.andExpect(status().isCreated());

		try (SqlSession session = readWriteUserSessionFactory.openSession()) {
			TestUserMapper testUserMapper = session.getMapper(TestUserMapper.class);

			User user = User.buildUser(testUserMapper.selectUserByUsername("jimmy123"));

			User expected = objectMapper.readValue(newUser, User.class);

			assertTrue(TestHelper.UserEquals(expected, user));
		}
	}

	@Test
	public void testUserCreationRemoteUser() throws Exception {
		String newUser = "{\n" +
				"  \"name\": \"Freddy Philips\",\n" +
				"  \"username\": \"Bret\",\n" +
				"  \"email\": \"Sincere@april.biz\",\n" +
				"  \"phone\": \"1-770-736-8031 x56442\",\n" +
				"  \"website\": \"hildegard.org\"\n" +
				"}";

		mvc.perform(post("/user")
				.content(newUser)
				.contentType(MediaType.APPLICATION_JSON).headers(httpHeaders))
				.andExpect(status().isCreated());

		try (SqlSession session = readWriteUserSessionFactory.openSession()) {
			TestUserMapper testUserMapper = session.getMapper(TestUserMapper.class);

			User user = User.buildUser(testUserMapper.selectUserByUsername("Bret"));

			User expected = objectMapper.readValue("{\n" +
							"  \"name\": \"Leanne Graham\",\n" +
							"  \"username\": \"Bret\",\n" +
							"  \"email\": \"Sincere@april.biz\",\n" +
							"  \"phone\": \"1-770-736-8031 x56442\",\n" +
							"  \"website\": \"hildegard.org\"\n" +
							"}",
					User.class);

			assertTrue(TestHelper.UserEquals(expected, user));
		}
	}

	@Test
	public void testUserUpdate() throws Exception {
		String newUser = "{\n" +
				"  \"name\": \"Freddy Philips\",\n" +
				"  \"username\": \"Bret\",\n" +
				"  \"email\": \"Freddy@april.biz\",\n" +
				"  \"phone\": \"1-770-736-8031 x56442\",\n" +
				"  \"website\": \"hildegard.org\"\n" +
				"}";
		String updatedUser = "{\n" +
				"  \"name\": \"Freddy Johnson\",\n" +
				"  \"username\": \"Brenda\",\n" +
				"  \"email\": \"Freddy@Johnson.com\",\n" +
				"  \"phone\": \"555-555-555\",\n" +
				"  \"website\": \"hildegard.org\"\n" +
				"}";

		String response = mvc.perform(post("/user")
				.content(newUser)
				.contentType(MediaType.APPLICATION_JSON).headers(httpHeaders))
				.andExpect(status().isCreated())
				.andReturn().getResponse().getContentAsString();

		CreatedResponse createdResponse = objectMapper.readValue(response, CreatedResponse.class);

		mvc.perform(put("/user/" + createdResponse.getId())
				.content(updatedUser)
				.contentType(MediaType.APPLICATION_JSON).headers(httpHeaders))
				.andExpect(status().isOk());

		try (SqlSession session = readWriteUserSessionFactory.openSession()) {
			TestUserMapper testUserMapper = session.getMapper(TestUserMapper.class);

			User user = User.buildUser(testUserMapper.selectUserByUsername("Brenda"));

			User expected = objectMapper.readValue(updatedUser, User.class);

			assertTrue(TestHelper.UserEquals(expected, user));
		}
	}

	@Test
	public void testDeleteUser() throws Exception {
		String newUser = "{\n" +
				"  \"name\": \"Princes Fiona\",\n" +
				"  \"username\": \"Fiona\",\n" +
				"  \"email\": \"Fiona@Shrek.biz\",\n" +
				"  \"phone\": \"555-555-5555\",\n" +
				"  \"website\": \"swamp.com\"\n" +
				"}";

		String response = mvc.perform(post("/user")
				.content(newUser)
				.contentType(MediaType.APPLICATION_JSON).headers(httpHeaders))
				.andExpect(status().isCreated())
				.andReturn().getResponse().getContentAsString();

		CreatedResponse createdResponse = objectMapper.readValue(response, CreatedResponse.class);

		mvc.perform(delete("/user/" + createdResponse.getId())
				.contentType(MediaType.APPLICATION_JSON).headers(httpHeaders))
				.andExpect(status().isOk());

		try (SqlSession session = readWriteUserSessionFactory.openSession()) {
			TestUserMapper testUserMapper = session.getMapper(TestUserMapper.class);

			User user = User.buildUser(testUserMapper.selectUserByUsername("Fiona"));

			assertNull(user);
		}
	}
}
