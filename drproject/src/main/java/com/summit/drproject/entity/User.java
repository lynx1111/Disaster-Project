package com.summit.drproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	private String username;
	
	@Column(name="name")
	private String name;
	
	@Column(name="role")
	private boolean role;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne(targetEntity = Job.class)
	@JoinColumn(name ="jobcode",referencedColumnName = "jobcode")
	private Job job;	
	public String getName() {
		return name;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String name, boolean role, String password , Job job) {
		super();
		this.username = username;
		this.name = name;
		this.role = role;
		this.job = job;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isRole() {
		return role;
	}
	public void setRole(boolean role) {
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
