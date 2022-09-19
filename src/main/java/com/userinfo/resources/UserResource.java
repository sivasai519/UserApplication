package com.userinfo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userinfo.model.User;
import com.userinfo.service.UserService;
import com.userinfo.utilites.UserResponse;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	UserService userService;

	@GetMapping(path = "/findAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAlluser() {
		return userService.getAllUsers();
	}

	@PostMapping(path = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping(path = "/findByUserId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User findById(@PathVariable int userId) {
		return userService.findByUserId(userId);
	}

	@GetMapping(path = "/findByObject", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findUserWithSpecific(@RequestBody User user) {
		return userService.findByMultipleValues(user);
	}

	@DeleteMapping(path = "/deleteByUserId/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse deleteUserWithId(@PathVariable int userId) {
		return userService.userDeleteById(userId);
	}

	@PutMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
}
