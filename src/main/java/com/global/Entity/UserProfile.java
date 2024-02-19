package com.global.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "User_Profile")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String currentJobTitle;
	private String bio;
	@OneToMany(mappedBy = "userProfile",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Experience> experience;
	@Lob
	private byte[] cvFile;

	@ElementCollection
	@CollectionTable(name = "user_profile_languages", joinColumns = @JoinColumn(name = "profile_id"))
	@Column(name = "language")
	private List<String> languages;

	
	 @OneToMany(mappedBy = "userProfile", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	    private List<Education> education= new ArrayList<>();

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany
	@JoinTable(name = "profile_skills", joinColumns = @JoinColumn(name = "profile_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> skills;


	


	public UserProfile(int id, String currentJobTitle, String bio, List<Experience> experience, byte[] cvFile,
			List<String> languages, List<Education> education, User user, List<Skill> skills) {
		super();
		this.id = id;
		this.currentJobTitle = currentJobTitle;
		this.bio = bio;
		this.experience = experience;
		this.cvFile = cvFile;
		this.languages = languages;
		this.education = education;
		this.user = user;
		this.skills = skills;
	}


	public UserProfile() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrentJobTitle() {
		return currentJobTitle;
	}

	public void setCurrentJobTitle(String currentJobTitle) {
		this.currentJobTitle = currentJobTitle;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	




	public List<Experience> getExperience() {
		return experience;
	}


	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}


	public byte[] getCvFile() {
		return cvFile;
	}

	public void setCvFile(byte[] cvFile) {
		this.cvFile = cvFile;
	}


	public List<String> getLanguages() {
		return languages;
	}


	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}


	public List<Education> getEducation() {
		return education;
	}


	public void setEducation(List<Education> education) {
		this.education = education;
	}


	public List<Skill> getSkills() {
		return skills;
	}


	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
