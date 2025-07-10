package com.example.student.management.system.exception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class globalexception {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request){
        Map<String, List<String>> errors=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            String fieldName=error.getField();
            String errormessage=error.getDefaultMessage();
            errors.computeIfAbsent(fieldName,key->new ArrayList<>()).add(errormessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<String> handleDateParseError(HttpMessageNotReadableException ex) {
            return ResponseEntity.badRequest().body("Invalid date format. Please use yyyy-MM-dd.");
        }

}
