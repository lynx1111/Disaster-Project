package com.summit.drproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="timesheet")
public class Timesheet {
	@Id
	@Column(name="sitecode")
	private String siteCode;
	
	@Column(name="name")
	private String name;
	
	@Column(name="hourlyrate")
	private int hours;
	
	@Column(name="maxhourperday")
	private double totalpay;
	
	public Timesheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Timesheet(String siteCode, String name, int hours, double totalpay) {
		super();
		this.siteCode = siteCode;
		this.name = name;
		this.hours = hours;
		this.totalpay = totalpay;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public double getTotalpay() {
		return totalpay;
	}
	public void setTotalpay(double totalpay) {
		this.totalpay = totalpay;
	}
	
}