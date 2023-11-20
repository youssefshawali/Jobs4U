package com.global.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Industry")
public class Industry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		type = type;
	}
	public Industry(int id, String type) {
		super();
		id = id;
		type = type;
	}
	public Industry() {
		super();
	}
}
