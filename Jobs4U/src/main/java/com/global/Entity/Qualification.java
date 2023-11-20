package com.global.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Qualification")
public class Qualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String degree;//phd etc. 
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
