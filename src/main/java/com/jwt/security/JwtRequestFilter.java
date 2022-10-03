package com.jwt.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jwt.model.User;
import com.jwt.service.CustomUserDetailsService;
import com.jwt.util.JwtUtill;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtill jwtUtill;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String header =request.getHeader("Authorization");
		String jwtToken=null;
		String userName=null;
		if(header !=null && header.startsWith("Bearer ") ) {
			jwtToken= header.substring(7);
			
			try {
				userName=jwtUtill.getUserNameFromToken(jwtToken);
				
			} 
			catch (IllegalArgumentException e) {
				System.out.println("unable to get jwt token");
			}
			catch (ExpiredJwtException e) {
				// TODO: handle exception
				System.out.println("jwt token is expired");
			}
		}
			else {
				System.out.println("jwt token not started with Bearer");
			
					}
		
		
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails=customUserDetailsService.loadUserByUsername(userName);
			if(jwtUtill.validateToken(jwtToken, userDetails))
			{
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=	new UsernamePasswordAuthenticationToken(userName, null,userDetails.getAuthorities());
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			
			
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
