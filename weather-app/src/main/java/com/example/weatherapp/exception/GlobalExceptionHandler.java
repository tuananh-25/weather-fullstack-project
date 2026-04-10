package com.example.weatherapp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // Bắt toàn bộ lỗi RuntimeException mà ta đã ném ra ở Service
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        // Trả về HTTP Status 400 (Bad Request) kèm câu thông báo lỗi
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
