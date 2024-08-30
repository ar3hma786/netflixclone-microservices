package com.netflix.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.userservice.entities.User;
import com.netflix.userservice.service.UserService;

@RestController
@RequestMapping("/api/admin")   
public class AdminController {
	
	   @Autowired
	   private UserService userService;
	
	   @GetMapping("/users")
	   public ResponseEntity<List<User>> findAllUsers() {
	        List<User> users = userService.findAllUsers();
	        return ResponseEntity.ok(users);
	    }

}
