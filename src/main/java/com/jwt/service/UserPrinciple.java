package com.jwt.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwt.model.User;


public abstract class UserPrinciple implements UserDetails {
 
//	private static final long serialVersionUID = 1L;
//
//	
//
//
//    private String userName;
//    @JsonIgnore
//    private String password;
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserPrinciple(String userName,String password,Collection<? extends GrantedAuthority> authorities) {
//        this.userName = userName;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//	public static UserPrinciple build(User user) {
//		List<GrantedAuthority> authorities = user.getRoles().stream()
//				.map(role -> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
//
//		return new UserPrinciple(
//
//				user.getName(), user.getPassward(), authorities);
//	}
//
//   
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }

  
}
