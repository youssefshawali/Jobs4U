package com.global.Entity;

import java.util.List;

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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Profile")
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String currentJobTitle;
	private String bio;
	private int experience;
	@Lob
	private byte[] cvFile;

	@ElementCollection
	@CollectionTable(name = "user_profile_languages", joinColumns = @JoinColumn(name = "profile_id"))
	@Column(name = "language")
	private List<String> languages;

	// Add this property to map to the user_profile_id column
	@OneToOne(mappedBy = "userProfile", fetch = FetchType.LAZY)
	private Education education;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany
	@JoinTable(name = "profile_skills", joinColumns = @JoinColumn(name = "profile_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skill> skills;

	public UserProfile(int id, String currentJobTitle, String bio, int experience, byte[] cvFile,
			Education education, User user) {
		super();
		this.id = id;
		this.currentJobTitle = currentJobTitle;
		this.bio = bio;
		this.experience = experience;
		this.cvFile = cvFile;
		this.education = education;
		this.user = user;
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

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public byte[] getCvFile() {
		return cvFile;
	}

	public void setCvFile(byte[] cvFile) {
		this.cvFile = cvFile;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
