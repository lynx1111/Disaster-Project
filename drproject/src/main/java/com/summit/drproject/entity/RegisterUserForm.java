package com.summit.drproject.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterUserForm {
	@NotNull
	private String role;
	@NotNull
	@Size(min=5, max=30)
	private String username;
	@NotNull
	@Size(min=5, max=20)
	private String password;
	@NotNull
	private String name;
	public RegisterUserForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegisterUserForm(String role, String username, String password, String name) {
		super();
		this.role = role;
		this.username = username;
		this.password = password;
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
