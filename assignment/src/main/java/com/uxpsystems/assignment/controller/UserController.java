package com.uxpsystems.assignment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uxpsystems.assignment.model.User;
import com.uxpsystems.assignment.service.UserService;

@RestController(value="assignement")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/assignement/user")
	public List<User> getListOfUsers() {
		return userService.getAllUsers();

	}

	@RequestMapping("/assignement/user/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		return userService.getUser(id);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/assignement/user")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
		
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/assignement/user/{id}")
	public void updateUser(@RequestBody User user, @PathVariable Long id) {
		userService.updateUser(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/assignement/user/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

}
