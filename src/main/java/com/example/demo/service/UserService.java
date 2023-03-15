package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.error.UserNotFoundException;

public interface UserService  {

	public User saveUser(User user);

	public void deleteUserById(String userId) throws UserNotFoundException;

	public List<User> getListOfUsers() throws UserNotFoundException;

	public User updateById(String userId, User user);

	public List<User> saveListOfUsers(List<User> user);

	public User fetchByIdByEmailByPhone(String userId, String email, String phone) throws UserNotFoundException;

	public List<User> findByCreateDateBetween(LocalDate date1, LocalDate date2);


}
