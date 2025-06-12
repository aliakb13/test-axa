package com.example.axa_test.model.recordDto;

import org.springframework.http.HttpStatus;

public record BaseResponse<T>(HttpStatus status, String message, T data) {}
