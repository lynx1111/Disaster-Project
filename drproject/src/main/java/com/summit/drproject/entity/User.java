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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="role")
	private boolean role;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne(targetEntity = Job.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="sitecode",referencedColumnName = "sitecode")
	private Job job;	
	public String getName() {
		return name;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, boolean role, String password , Job job) {
		super();
		this.name = name;
		this.role = role;
		this.job = job;
		this.password = password;
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
