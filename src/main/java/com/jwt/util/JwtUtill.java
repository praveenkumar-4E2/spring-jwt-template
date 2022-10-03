package com.jwt.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtill {

	private static final String SECRET_KEY="PRAVEEN";
	private static final int TOKEN_VALIDITY = 3600 * 5;

	
	public String getUserNameFromToken(String token)
	{
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	private <T> T getClaimFromToken(String token ,Function<Claims,T> claimResolver)
	{
		final Claims claims=getAllClaimsfromToken(token);
		return claimResolver.apply(claims);
		
	}
	
	private Claims getAllClaimsfromToken(String token)
	{
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	public boolean validateToken(String token ,UserDetails userDetails)
	{
		String userName = getUserNameFromToken(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExperies(token));
		
	}
	
	public boolean isTokenExperies(String  token)
	{
		final Date expirationDate = getExpirationdateFromToken(token);
		return expirationDate.before(new Date());
	}
	
	private Date getExpirationdateFromToken(String token)
	{
		return getClaimFromToken(token,Claims::getExpiration);
	}
	
	public String generateToken(UserDetails userDetails) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
