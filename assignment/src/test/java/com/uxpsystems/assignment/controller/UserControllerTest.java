package com.uxpsystems.assignment.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.model.UserStatus;
import com.uxpsystems.assignment.service.UserService;
import com.uxpsystems.assignment.utils.Util;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	private MockMvc mockMvc;
	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void getAllUsersTest() throws Exception {
		User user1 = new User(1L, "testuser", "testpassword", UserStatus.ACTIVATED);
		User user2 = new User(2L, "amdocs", "test", UserStatus.ACTIVATED);
		List<User> usersList = Arrays.asList(user1, user2);
		Mockito.when(userService.getAllUsers()).thenReturn(usersList);
		mockMvc.perform(MockMvcRequestBuilders.get("/assignement/user")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].userName", Matchers.is("testuser")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].password", Matchers.is("testpassword")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].status", Matchers.is(UserStatus.ACTIVATED.toString())))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(2)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].userName", Matchers.is("amdocs")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].password", Matchers.is("test")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].status", Matchers.is(UserStatus.ACTIVATED.toString())));

	}

	@Test
	public void getUserByIdTest() throws Exception {

		User user = new User(1L, "amdocs", "test", UserStatus.ACTIVATED);
		Mockito.when(userService.getUser(1L)).thenReturn(Optional.of(user));
		mockMvc.perform(MockMvcRequestBuilders.get("/assignement/user/1")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.userName", Matchers.is("amdocs")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.password", Matchers.is("test")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.is(UserStatus.ACTIVATED.toString())));

	}


	@Test
	public void addUserTest() throws Exception {
		User user = new User(2L, "amdocs", "test", UserStatus.ACTIVATED);
		mockMvc.perform(post("/assignement/user").contentType(MediaType.APPLICATION_JSON).content(Util.asJsonString(user)))
				.andExpect(status().isOk());
	}

	@Test
	public void updateUserTest() throws Exception {
		User user = new User(2L, "amdocs", "test", UserStatus.ACTIVATED);
		mockMvc.perform(put("/assignement/user/{id}", user.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(Util.asJsonString(user))).andExpect(status().isOk());
	}
	
	@Test
    public void deleteUserTest() throws Exception {
		User user = new User(2L, "amdocs", "test", UserStatus.ACTIVATED);
        mockMvc.perform(
                delete("/assignement/user/{id}", user.getId()))
                .andExpect(status().isOk());

         }

	

}