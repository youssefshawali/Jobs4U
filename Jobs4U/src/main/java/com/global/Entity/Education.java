package com.global.Entity;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private int StartYear;
	private int EndYear;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getStartYear() {
		return StartYear;
	}
	public void setStartYear(int startYear) {
		StartYear = startYear;
	}
	public int getEndYear() {
		return EndYear;
	}
	public void setEndYear(int endYear) {
		EndYear = endYear;
	}
	public Education(int id, int startYear, int endYear) {
		super();
		Id = id;
		StartYear = startYear;
		EndYear = endYear;
	}
	public Education() {
		super();
	}
}
