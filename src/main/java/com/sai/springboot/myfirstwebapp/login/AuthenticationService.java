package com.sai.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username,String password) {
		
		boolean isValidUserName = username.equals("Sai");
		boolean isValidPassword = password.equals("Dummy");
		return isValidUserName && isValidPassword;
	}
}
