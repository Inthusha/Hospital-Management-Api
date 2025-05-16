package com.example.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Entity.User;
import com.example.springboot.Service.UserService;
import com.example.springboot.dto.loginRequest;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") 
public class UserController 
{
	
	@Autowired
	private UserService service;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user,Authentication authentication)
	{
		
		try {
             service.register(user);
            return ResponseEntity.ok("Account created successfully"); 
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
	
		
	}
	
	@PostMapping("/login")
	public String login(@RequestBody loginRequest request) 
	{
		try {
	        
	          return service.login(request);

	        
	         //return ResponseEntity.ok("Login successful");

	    } catch (RuntimeException e) {
	        
	        return "Invalid email or password";
	    }
	    
	}
	
	
}
