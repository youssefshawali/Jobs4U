package com.global.Entity;

import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String field;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public Department(int id, String field) {
		super();
		Id = id;
		this.field = field;
	}
	public Department() {
		super();
	}
	
	

}
