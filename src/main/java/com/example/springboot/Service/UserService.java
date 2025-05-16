package com.example.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springboot.Entity.Role;
import com.example.springboot.Entity.User;
import com.example.springboot.Repository.UserRepository;
import com.example.springboot.dto.loginRequest;

@Service
public class UserService 
{
	@Autowired
	private UserRepository repo;
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	private JWTService jwtService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public User register(User user)
	{
		
	   
		if(repo.existsByEmail(user.getEmail()))
		{
			throw new RuntimeException("Email already exists");
		}
		
		 if (user.getRole() == Role.ADMIN) {
		        throw new RuntimeException("Cannot register user with ADMIN role");
		    }
		
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}
	
	public String login(loginRequest request) {
	   Authentication authentication=
        authManager.authenticate( new UsernamePasswordAuthenticationToken
        		(request.getEmail(),request.getPassword()));
	   
	   if(authentication.isAuthenticated())
	   {
		   User user = repo.findByEmail(request.getEmail());
		   return jwtService.generateToken(user);
	   }
	   else
	   {
		   return "fail";
	   }
	   
	
	
	
	
	}

}
