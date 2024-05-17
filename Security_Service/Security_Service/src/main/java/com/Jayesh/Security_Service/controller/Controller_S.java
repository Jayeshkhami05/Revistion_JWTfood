package com.Jayesh.Security_Service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Jayesh.Security_Service.entity.LogInRequste;
import com.Jayesh.Security_Service.entity.MyUser;
import com.Jayesh.Security_Service.service.JWTService;
import com.Jayesh.Security_Service.service.MyUserSerivees;

@RestController
@RequestMapping("/Sauth")
public class Controller_S {
	
	@Autowired
	private MyUserSerivees serivees;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTService jwtService;
	
	@PostMapping("/register")
	public String register(@RequestBody MyUser myUser) {
		return serivees.resgiter(myUser);
	}
	
	@PostMapping("/token")
	public String genrateToken(@RequestBody LogInRequste logInRequste) {
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logInRequste.getName(), logInRequste.getPasscode()));
		if(authentication.isAuthenticated()) {
			return jwtService.GenratedToken(logInRequste.getName());
		}return "Wrong User Name Or Password !!!!!";
	}
	
	@GetMapping("/valied")
	public String Valied(@RequestParam String token) {
		jwtService.Extractallclaims(token);
		return "Token is valied....";
		}
}
