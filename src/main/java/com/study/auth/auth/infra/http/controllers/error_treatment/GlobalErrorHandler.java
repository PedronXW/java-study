package com.study.auth.auth.infra.http.controllers.error_treatment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.study.auth.auth.domain.application.errors.UserAlreadyExistsError;
import com.study.auth.auth.domain.application.errors.UserNotFoundError;

@RestControllerAdvice
public class GlobalErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalErrorHandler.class);

    @ExceptionHandler(UserAlreadyExistsError.class)
    public ResponseEntity<ErrorDTO> handleBusinessException(UserAlreadyExistsError ex) {
        return new ResponseEntity<>(new ErrorDTO(UserAlreadyExistsError.message), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundError.class)
    public ResponseEntity<ErrorDTO> handleNoContentException() {
        return new ResponseEntity<>(new ErrorDTO(UserNotFoundError.message), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
        String message = "Unexpected server error.";
        LOGGER.error(message, unexpectedException);
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
