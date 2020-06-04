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
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "hourlyrate")
	private String hourlyrate;
	
	@Column(name = "maxhourperday")
	private String maxhourperday;
	
	public Job() {
		
	}
	
	public Job(Long id, String description, String hourlyrate, String maxhourperday ) {
		super();
		this.id=id;
		this.description = description;
		this.hourlyrate = hourlyrate;
		this.maxhourperday = maxhourperday;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHourlyrate() {
		return hourlyrate;
	}

	public void setHourlyrate(String hourlyrate) {
		this.hourlyrate = hourlyrate;
	}

	public String getMaxhourperday() {
		return maxhourperday;
	}

	public void setMaxhourperday(String maxhourperday) {
		this.maxhourperday = maxhourperday;
	}
	
	
	
}
