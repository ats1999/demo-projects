package com.jakson.demo;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonObjectTest {
	@PostMapping("/json")
	public String json(@RequestBody String body) {
		return (String) new JSONObject(body).get("name");
	}
}
