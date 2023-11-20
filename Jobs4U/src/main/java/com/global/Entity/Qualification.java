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
	private int Id;
	private String Degree;//phd etc. 
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDegree() {
		return Degree;
	}
	public void setDegree(String degree) {
		Degree = degree;
	}
	public Qualification(int id, String degree) {
		super();
		Id = id;
		Degree = degree;
	}
	public Qualification() {
		super();
	}
	

}
