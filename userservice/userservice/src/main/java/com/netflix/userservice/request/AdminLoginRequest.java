package com.netflix.userservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminLoginRequest {
	
	private String username;
	
	private String password;

}
