package com.netflix.userservice.service;

import java.util.List;

import com.netflix.userservice.entities.User;
import com.netflix.userservice.exception.UserException;



public interface UserService {
	
	 	public User findUserById(Long userId) throws UserException;
		
		public User findUserProfileByJwt(String jwt) throws UserException;
		
		public User findUserByEmail(String email) throws UserException;
		
		public List<User> findAllUsers();

}
