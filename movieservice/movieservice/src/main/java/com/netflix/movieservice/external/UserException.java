package com.netflix.movieservice.external;


@SuppressWarnings("serial")
public class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }
}
