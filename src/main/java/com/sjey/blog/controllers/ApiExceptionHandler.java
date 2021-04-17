package com.sjey.blog.controllers;

import com.sjey.blog.error.ApiErrorResponse;
import com.sjey.blog.error.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleApiException(PostNotFoundException ex) {
        ApiErrorResponse response = new ApiErrorResponse("Error-001",
                "No post found" + ex.getId());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
