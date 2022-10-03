package com.jwt.service;

import java.util.ArrayList;


import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.dto.JwtResponse;
import com.jwt.dto.UserLoginDto;
import com.jwt.model.Role;
import com.jwt.model.User;
import com.jwt.repository.UserRepository;
import com.jwt.util.JwtUtill;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtUtill jwtUtill;


	@Autowired
	private AuthenticationManager authenticationManager;
	
	 public String createJwtToken(UserLoginDto jwtRequest) throws Exception {
	        String userName = jwtRequest.getUserName();
	        String userPassword = jwtRequest.getPassword();
	        authenticate(userName, userPassword);

	        UserDetails userDetails = loadUserByUsername(userName);
	        String newGeneratedToken = jwtUtill.generateToken(userDetails);

	        User user = userRepository.findByName(userName);
	        return newGeneratedToken;
	    }
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByName(username);
		if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getName(),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
	}
	
	
	private Set getAuthority(User user)
	{
		Set<SimpleGrantedAuthority> authorities=new HashSet<>();
		user.getRoles().forEach(role->
		authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName())));
		return authorities;
	}
	
	private void authenticate (String userName ,String password) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED",e);
		}
		catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS",e);
	}
	
	
	
}
}
