package com.springprojects.inputvalidation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class RequestBodyValidation {
	
	@PostMapping("/register")
	public RegisterModel register(@RequestBody @Valid RegisterModel body) {
		return body;
	}
	
}
