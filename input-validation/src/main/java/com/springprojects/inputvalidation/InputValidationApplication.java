package com.springprojects.inputvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@SpringBootApplication
@RestController
@Validated
public class InputValidationApplication {

    public static void main(String[] args) {
        SpringApplication.run(InputValidationApplication.class, args);
    }

 
    @GetMapping("/register")
    public String register(@RequestParam @Size(min=5,max=10) String name, @RequestParam @Min(18) int age) {
    	return String.format("Hi %s \n Since you are older then 18 and your age is %s, we are letting you in:)", name,age);
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handle(ConstraintViolationException ex) {
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
}