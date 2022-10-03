package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.dto.JwtResponse;
import com.jwt.dto.UserLoginDto;
import com.jwt.service.CustomUserDetailsService;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private  CustomUserDetailsService customUserDetailsService;
	
	@PostMapping("/auth/login")
	public String createJwtToken(@RequestBody UserLoginDto loginDto) throws Exception
	{
		return customUserDetailsService.createJwtToken(loginDto);
		
	}
	
}
