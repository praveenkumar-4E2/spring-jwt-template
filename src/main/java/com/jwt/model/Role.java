package com.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity

public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(nullable = false,unique = true)
	private String roleName;
	

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Role(int id, String name) {
		super();
		Id = id;
		this.roleName = name;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String name) {
		this.roleName = name;
	}


	@Override
	public String toString() {
		return "Role [Id=" + Id + ", name=" + roleName + "]";
	}
	
	
	
}
