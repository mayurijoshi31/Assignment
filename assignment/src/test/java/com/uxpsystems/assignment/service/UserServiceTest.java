package com.uxpsystems.assignment.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.uxpsystems.assignment.dao.UserRepository;
import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.model.UserStatus;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
    UserService userService;
     
    @Mock
    UserRepository userRepository;
 
     @Test
	public void getAllUsersTest() throws Exception {
		User user1 = new User(1L, "testuser", "testpassword", UserStatus.ACTIVATED);
		User user2 = new User(2L, "amdocs", "test", UserStatus.ACTIVATED);
		List<User> usersList = Arrays.asList(user1, user2);
		Mockito.when(userRepository.findAll()).thenReturn(usersList);
		assertEquals(usersList, userService.getAllUsers());
		
	}

	@Test
	public void getUserByIdTest() throws Exception {

		User user = new User(1L, "amdocs", "test", UserStatus.ACTIVATED);
		
		Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		assertEquals(Optional.of(user), userService.getUser(user.getId()));
	}


	@Test
	public void addUserTest() throws Exception {
		User user = new User(2L, "amdocs", "test", UserStatus.ACTIVATED);
		List<User> usersList = Arrays.asList(user);
		
		Mockito.when(userRepository.save(user)).thenReturn(user);
		userService.addUser(user);
		Mockito.when(userRepository.findAll()).thenReturn(usersList);
		assertEquals(usersList, userService.getAllUsers());
		
		}

	@Test
	public void updateUserTest() throws Exception {
		User user = new User(2L, "amdocs", "test", UserStatus.ACTIVATED);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		userService.updateUser(user);
		Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		assertEquals(Optional.of(user), userService.getUser(user.getId()));
		
	}
	
	
}
