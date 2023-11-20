package com.global.Entity;

import java.time.LocalTime;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String jobTitle;
	private String description;
	private String requirments;
	private String experience;
	private String workHours;//partime or full time
	private String workPlaceType;//remote or onsite
	private String category;//
	private String status;//grad or student
	private int applicantsCount;
	private LocalTime dateTime;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		jobTitle = jobTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		description = description;
	}
	public String getRequirments() {
		return requirments;
	}
	public void setRequirments(String requirments) {
		requirments = requirments;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		experience = experience;
	}
	public String getWorkHours() {
		return status;
	}
	public void setWorkHours(String workHours) {
		status = workHours;
	}
	public String getWorkPlaceType() {
		return workPlaceType;
	}
	public void setWorkPlaceType(String workPlaceType) {
		workPlaceType = workPlaceType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		status = status;
	}
	public int getApplicantsCount() {
		return applicantsCount;
	}
	public void setApplicantsCount(int applicantsCount) {
		applicantsCount = applicantsCount;
	}
	public LocalTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalTime dateTime) {
		dateTime = dateTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		location = location;
	}
	public Job(int id, String jobTitle, String description, String requirments, String experience, String workHours,
			String workPlaceType, String category, String status, int applicantsCount, LocalTime dateTime,
			String location) {
		super();
		id = id;
		jobTitle = jobTitle;
		description = description;
		requirments = requirments;
		experience = experience;
		status = workHours;
		workPlaceType = workPlaceType;
		category = category;
		status = status;
		applicantsCount = applicantsCount;
		dateTime = dateTime;
		location = location;
	}
	public Job() {
		super();
	}
	
	
	
}
