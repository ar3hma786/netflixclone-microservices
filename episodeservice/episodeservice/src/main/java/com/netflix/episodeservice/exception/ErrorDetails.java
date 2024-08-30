package com.netflix.episodeservice.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDetails {
	
	private String message;
	
	private String error;
	
	private LocalDateTime ldt;

}
