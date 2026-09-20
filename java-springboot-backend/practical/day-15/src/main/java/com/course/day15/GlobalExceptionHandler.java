package com.course.day15;

import java.time.Instant;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> nf(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("timestamp", Instant.now(), "status", 404, "error", "RESOURCE_NOT_FOUND", "message", ex.getMessage()));
    }
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Map<String, Object>> cf(ConflictException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("timestamp", Instant.now(), "status", 409, "error", "CONFLICT", "message", ex.getMessage()));
    }
}
