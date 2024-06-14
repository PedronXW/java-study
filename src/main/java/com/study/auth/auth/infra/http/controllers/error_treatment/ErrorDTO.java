package com.study.auth.auth.infra.http.controllers.error_treatment;

public class ErrorDTO {
    private String message;

    public ErrorDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
