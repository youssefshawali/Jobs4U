package com.global.Entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String jobTitle;
	private String description;
	private String target;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	private String requirments;
	private int experience;// number of years
	private String category;// it/software
	private String status;// opened / closed
	private int applicantsCount;
	private LocalDateTime dateTime=LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "location_id") // Name of the foreign key column in the Job table
	private Location location;
	@ManyToOne
	@JoinColumn(name = "company_id") // Name of the foreign key column in the Job table
	private Company company;

	@ManyToMany
	@JoinTable(name = "job_qualification", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "qualification_id"))
	private List<Qualification> qualification;

	@ManyToOne
	@JoinColumn(name = "department_id") // Name of the foreign key column in the Job table
	private Department department;

	@ManyToMany
	@JoinTable(name = "job_career_level", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "career_level_id"))
	private List<CareerLevel> careerLevels = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "Job_required_skills", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> skills;

	private String workHours;// partime or full time
	private String workPlaceType;// remote or onsite
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "job_applicants", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> applicants;

	public Job(int id, String jobTitle, String description, String target, String requirments, int experience,
			String category, String status, int applicantsCount, LocalDateTime dateTime, Location location, Company company,
			List<Qualification> qualification, Department department, List<CareerLevel> careerLevels,
			List<Skill> skills, String workHours, String workPlaceType, List<User> applicants) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.description = description;
		this.target = target;
		this.requirments = requirments;
		this.experience = experience;
		this.category = category;
		this.status = status;
		this.applicantsCount = applicantsCount;
		this.dateTime = dateTime;
		this.location = location;
		this.company = company;
		this.qualification = qualification;
		this.department = department;
		this.careerLevels = careerLevels;
		this.skills = skills;
		this.workHours = workHours;
		this.workPlaceType = workPlaceType;
		this.applicants = applicants;
	}

	public Job() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequirments() {
		return requirments;
	}

	public void setRequirments(String requirments) {
		this.requirments = requirments;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getWorkHours() {
		return workHours;
	}

	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}

	public String getWorkPlaceType() {
		return workPlaceType;
	}

	public void setWorkPlaceType(String workPlaceType) {
		this.workPlaceType = workPlaceType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getApplicantsCount() {
		return applicantsCount;
	}

	public void setApplicantsCount(int applicantsCount) {
		this.applicantsCount = applicantsCount;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime() {
		  if (this.dateTime == null) {
		        this.dateTime = LocalDateTime.now();}
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Company getCompanyId() {
		return company;
	}

	public void setCompanyId(Company company) {
		this.company = company;
	}

	public List<Qualification> getQualification() {
		return qualification;
	}

	public void setQualification(List<Qualification> qualification) {
		this.qualification = qualification;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<CareerLevel> getCareerLevels() {
		return careerLevels;
	}

	public void setCareerLevels(List<CareerLevel> careerLevels) {
		this.careerLevels = careerLevels;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public List<User> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<User> applicants) {
		this.applicants = applicants;
	}

	public void setCareerLevelOneByOne(CareerLevel careerLevel) {
		this.careerLevels.add(careerLevel);
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	
}
