package com.example.springboot.dto;

public class loginResponse 
{
	
  private String token;

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

@Override
public String toString() {
	return "loginResponse [token=" + token + "]";
}

public loginResponse(String token) {
	super();
	this.token = token;
}

public loginResponse() {
	super();
}
  

}
