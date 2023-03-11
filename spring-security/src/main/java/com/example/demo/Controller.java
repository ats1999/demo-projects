package com.example.demo;

import java.net.HttpCookie;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Controller {

	@GetMapping("/register")
	public ResponseEntity<String> geUser(HttpServletResponse response) {
		HttpCookie cookie = new HttpCookie("token", "xxx");
		return ResponseEntity.status(HttpStatus.OK).header(HttpHeaders.SET_COOKIE, cookie.toString())
				.body("Hello, cookie");
	}

	@GetMapping("/hello")
	public String login(@RequestAttribute String UUID) {
		return "Here is your request id: "+UUID;
	}
}
