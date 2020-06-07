package com.summit.drproject.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sitecode")
	private String id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "hourlyrate")
	private int hourlyrate;
	
	@Column(name = "maxhourperday")
	private double maxhourperday;
	

	
	public Job() {
		
	}
	
	public Job(String id, String description, int hourlyrate, double maxhourperday ) {
		super();
		this.id=id;
		this.description = description;
		this.hourlyrate = hourlyrate;
		this.maxhourperday = maxhourperday;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHourlyrate() {
		return hourlyrate;
	}

	public void setHourlyrate(int hourlyrate) {
		this.hourlyrate = hourlyrate;
	}

	public double getMaxhourperday() {
		return maxhourperday;
	}

	public void setMaxhourperday(double maxhourperday) {
		this.maxhourperday = maxhourperday;
	}
	
	
	
}
