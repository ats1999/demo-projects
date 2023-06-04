package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {
	@Autowired
	SimpUserRegistry simpUserRegistry;

	@GetMapping("/userCount")
	public int test() throws InterruptedException {
		return simpUserRegistry.getUserCount();
	}
	
}
