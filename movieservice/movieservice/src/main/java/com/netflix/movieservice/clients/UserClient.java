package com.netflix.movieservice.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.netflix.movieservice.external.User;
import com.netflix.movieservice.external.UserException;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

    @GetMapping("/api/users/profile")
    User findUserProfileByJwt(@RequestHeader("Authorization") String jwt) throws UserException;

}
