package com.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);
	Boolean existsByName(String name);

	}
