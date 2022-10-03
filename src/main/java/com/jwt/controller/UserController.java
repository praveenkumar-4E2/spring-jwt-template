package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.User;
import com.jwt.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/reg")
	public User registerNewUser(@RequestBody User user)
	{
		return userService.registerNewUser(user);
	}
	
	
	@GetMapping("/foradmin")
	@PreAuthorize("hasRole('admin')")
	public String forAdmin()
	{
		return "only accesable to admin";
	}
	
	@GetMapping("/foruser")
	@PreAuthorize("hasRole('user')")
	public String forUser()
	{
		return "only accesable to user";
	}
}
