package com.example.hello.product;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(exception = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage("Bad request");
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(exception = ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
    }

}
