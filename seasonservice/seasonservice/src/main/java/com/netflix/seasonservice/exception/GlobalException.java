package com.netflix.seasonservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(SeasonsException.class)
	public ResponseEntity<ErrorDetails> handleSeasonsException(SeasonsException seasonsException, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(seasonsException.getMessage(), request.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllException(Exception exception, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
