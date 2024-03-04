package com.global.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Skill")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	@JsonIgnore
	@ManyToMany(mappedBy = "skills")
	private List<Job> jobs;

	@JsonIgnore
	@ManyToMany(mappedBy = "skills")
	private List<UserProfile> userProfiles;

	public Skill(int id, String name, List<Job> jobs, List<UserProfile> userProfiles) {
		super();
		this.id = id;
		this.name = name;
		this.jobs = jobs;
		this.userProfiles = userProfiles;
	}

	public Skill() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

}
