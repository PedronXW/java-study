package com.study.auth.auth.domain.application.errors;

public class UserAlreadyExistsError extends RuntimeException {

    public static String message = "User already exists";

    public UserAlreadyExistsError() {
        super(message);
    }
    
}
