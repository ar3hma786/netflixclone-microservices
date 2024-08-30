package com.netflix.movieservice.exception;

@SuppressWarnings("serial")
public class MoviesException extends Exception {
 
	public MoviesException(String message) {
        super(message);
    }
}
