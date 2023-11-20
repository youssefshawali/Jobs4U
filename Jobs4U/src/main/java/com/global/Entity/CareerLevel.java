package com.global.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "CareerLevel")
public class CareerLevel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String level;//senior,junior
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public CareerLevel(int id, String level) {
		super();
		Id = id;
		this.level = level;
	}
	public CareerLevel() {
		super();
	}
}
