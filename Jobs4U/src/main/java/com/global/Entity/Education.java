package com.global.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
@Table(name = "Education")
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int startYear;
	private int endYear;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		startYear = startYear;
	}
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		endYear = endYear;
	}
	public Education(int id, int startYear, int endYear) {
		super();
		id = id;
		startYear = startYear;
		endYear = endYear;
	}
	public Education() {
		super();
	}
}
