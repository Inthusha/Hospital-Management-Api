package com.example.springboot.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
	@GetMapping ("/welcome")
	public ResponseEntity <String> welcome() {
	    return ResponseEntity.ok("Welcome! You are authenticated.");
	}


}
