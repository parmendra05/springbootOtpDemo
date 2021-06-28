package com.pack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyUsers {
	@Id
	private String email;
	private String name;
	private String password;
	private String role;
	private String mobile;
	
	public MyUsers() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public MyUsers(String email, String name, String password, String role, String mobile) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.role = role;
		this.mobile = mobile;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	
}
