package com.global.Entity;

import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Name;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Skill(int id, String name) {
		super();
		Id = id;
		Name = name;
	}
	public Skill() {
		super();
	}
	
}
