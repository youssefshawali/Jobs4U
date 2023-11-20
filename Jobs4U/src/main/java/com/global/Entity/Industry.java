package com.global.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Industry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Type;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Industry(int id, String type) {
		super();
		Id = id;
		Type = type;
	}
	public Industry() {
		super();
	}
}
