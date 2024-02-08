package com.global.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "CareerLevel")
public class CareerLevel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String level;//senior,junior
	
	 @ManyToMany(mappedBy = "careerLevels")
	    private List<Job> jobs;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public CareerLevel(int id, String level) {
		super();
		id = id;
		this.level = level;
	}
	public CareerLevel() {
		super();
	}
}
