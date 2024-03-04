package com.global.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Experience {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	String jobTitle;
	String companyName;
	Date startDate;
	Date endDate;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_Id")
	private UserProfile userProfile;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Location companyLocation;

	public Experience(int id, String jobTitle, String companyName, Location companyLocation, Date startDate,
			Date endDate, UserProfile userProfile) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.companyLocation = companyLocation;
		this.startDate = startDate;
		this.endDate = endDate;
		this.userProfile = userProfile;
	}

	public Experience() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Location getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(Location companyLocation) {
		this.companyLocation = companyLocation;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}
