package com.global.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Qualification")
public class Qualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String degree;//phd etc. 
	
	@ManyToMany(mappedBy = "qualification")
    private List<Job> jobs;
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		degree = degree;
	}
	public Qualification(int id, String degree) {
		super();
		id = id;
		degree = degree;
	}
	public Qualification() {
		super();
	}
	

}
