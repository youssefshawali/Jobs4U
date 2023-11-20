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
	private int Id;
	private String JobTitle;
	private String Description;
	private String Requirments;
	private String Experience;
	private String WorkHours;//partime or full time
	private String WorkPlaceType;//remote or onsite
	private String Category;//
	private String Status;//grad or student
	private int ApplicantsCount;
	private LocalTime DateTime;
	private String Location;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getRequirments() {
		return Requirments;
	}
	public void setRequirments(String requirments) {
		Requirments = requirments;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	public String getWorkHours() {
		return WorkHours;
	}
	public void setWorkHours(String workHours) {
		WorkHours = workHours;
	}
	public String getWorkPlaceType() {
		return WorkPlaceType;
	}
	public void setWorkPlaceType(String workPlaceType) {
		WorkPlaceType = workPlaceType;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getApplicantsCount() {
		return ApplicantsCount;
	}
	public void setApplicantsCount(int applicantsCount) {
		ApplicantsCount = applicantsCount;
	}
	public LocalTime getDateTime() {
		return DateTime;
	}
	public void setDateTime(LocalTime dateTime) {
		DateTime = dateTime;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public Job(int id, String jobTitle, String description, String requirments, String experience, String workHours,
			String workPlaceType, String category, String status, int applicantsCount, LocalTime dateTime,
			String location) {
		super();
		Id = id;
		JobTitle = jobTitle;
		Description = description;
		Requirments = requirments;
		Experience = experience;
		WorkHours = workHours;
		WorkPlaceType = workPlaceType;
		Category = category;
		Status = status;
		ApplicantsCount = applicantsCount;
		DateTime = dateTime;
		Location = location;
	}
	public Job() {
		super();
	}
	
	
	
}
