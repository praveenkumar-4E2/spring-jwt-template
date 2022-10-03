package com.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.Role;
import com.jwt.service.RoleService;

@RestController
@CrossOrigin
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/auth/createnewrole")
	public Role createNewRole(@RequestBody Role role)
	{
		return roleService.createNewRole(role);
	}

}
