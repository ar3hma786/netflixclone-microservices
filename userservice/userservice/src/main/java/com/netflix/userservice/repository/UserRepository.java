package com.netflix.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netflix.userservice.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
