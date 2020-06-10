package com.summit.drproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="username")
	private String username;
	
	@Column(name="name")
	private String name;
	
	@Column(name="role")
	private String role;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne(targetEntity = Job.class)
	@JoinColumn(name ="jobcode",referencedColumnName = "jobcode")
	private Job job;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String name, String role, String password , Job job) {
		super();
		this.username = username;
		this.name = name;
		this.role = role;
		this.job = job;
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}