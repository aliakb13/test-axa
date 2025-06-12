package com.example.axa_test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.axa_test.model.recordDto.BaseResponse;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalException {
  
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<BaseResponse<String>> entityNotFoundHandler(EntityNotFoundException e) {
    var response = new BaseResponse<String>(HttpStatus.NOT_FOUND, e.getMessage(), "Entity tidak ditemukan");
    return new ResponseEntity<BaseResponse<String>>(response, HttpStatus.NOT_FOUND);
  }
}
