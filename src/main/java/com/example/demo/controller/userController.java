package com.example.demo.controller;

import java.time.LocalDate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.service.UserService;


@RestController
public class userController {
	@Autowired
	private UserService  userService;
	private final Logger LOGGER=LoggerFactory.getLogger(userController.class);
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		LOGGER.info("Inside saveUser of userController");
		return userService.saveUser(user);
		}
	@PostMapping("/users/list")
	public List<User> saveListOfUsers(@RequestBody List<User> user) {
		LOGGER.info("Inside saveListOfUsers of userController");
		return userService.saveListOfUsers(user);
		
	}
	@GetMapping("/users")
	public List<User> getListOfUsers() throws UserNotFoundException {
		LOGGER.info("Inside getListOfUsers of userController");
		return userService.getListOfUsers();
		}
		
	@GetMapping("/usersBy")
	public User fetchByIdByEmailByPhone(@RequestParam(required = false) String userId,@RequestParam(required = false) String email,@RequestParam(required = false) String phone) throws UserNotFoundException {
		LOGGER.info("Inside fetchByIdByEmailByPhone of userController");
		return userService.fetchByIdByEmailByPhone(userId,email,phone);
		
	}
	@GetMapping("/users/dates")
	public List<User> findByCreateDateBetween(@PathVariable LocalDate date1, @PathVariable LocalDate date2) {
		LOGGER.info("Inside findByCreateDateBetween of userController");
		return userService.findByCreateDateBetween(date1,date2);
		
	}
	@PutMapping("/users/{id}")
	public User updateById(@PathVariable("id") String userId,@RequestBody User user) {
		LOGGER.info("Inside updateById of userController");
		return userService.updateById(userId,user);
		
	}
	@DeleteMapping("/users/{id}")
	private String deleteUserByIdController(@PathVariable("id") String userId) throws UserNotFoundException {
		LOGGER.info("Inside deleteUserByIdController of userController");
		 userService.deleteUserById(userId);
		return "Data Deleted Successfully";

	}
	

}
