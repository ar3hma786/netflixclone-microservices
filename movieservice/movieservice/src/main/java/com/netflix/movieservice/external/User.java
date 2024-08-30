package com.netflix.movieservice.external;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {


	    private Long userId;


	    private String firstName;


	    private String lastName;

	
	    private String username;

	
	    private String email;


	    private String password;

	
	    private ROLE role;

	  
	    private Long moviesId;

	    private Long tvshowsId;

	    private LocalDateTime datetime;
	
}
