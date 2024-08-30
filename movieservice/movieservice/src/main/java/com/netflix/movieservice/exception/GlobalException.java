package com.netflix.movieservice.exception;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.netflix.movieservice.external.UserException;

@ControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(MoviesException.class)
	public ResponseEntity<ErrorDetails> handleMoviesException(MoviesException movieException, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(movieException.getMessage(), request.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> handleUserException(UserException movieException, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(movieException.getMessage(), request.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllException(Exception exception, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), request.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
