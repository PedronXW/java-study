package com.study.auth.auth.domain.application.errors;

public class UserNotFoundError extends RuntimeException {

    public static String message = "User not Found";

    public UserNotFoundError() {
        super(message);
    }
    
}
