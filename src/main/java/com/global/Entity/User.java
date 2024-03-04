package com.global.Entity;

import java.awt.image.BufferedImage;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String fname;
	private String lname;
	private String phoneNumber;
	private String email;
	private String password;
	private int age;
	private String gender;
	@Lob
	private byte[] profilePicture;
	
	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	
	@OneToOne(mappedBy = "user", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)

	private UserProfile userProfile;
	@ManyToMany(mappedBy = "applicants")
	private List<Job> appliedJobs;

	public User(int id, String fname, String lname, String phoneNumber, String email, String password, int age,
			byte[] profilePicture, UserProfile userProfile, List<Job> appliedJobs) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		setPassword(password);
		this.age = age;
		this.profilePicture = profilePicture;
		this.userProfile = userProfile;
		this.appliedJobs = appliedJobs;
	}

	
	public User() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	private static boolean isHashed(String password) {
        return password != null && password.startsWith("$2a$");
    }

    public void setPassword(String password) {
        // Check if the password is already hashed
        if (!isHashed(password)) {
            // Hash the password before storing it
            this.password = encoder.encode(password);
        } else {
            // Password is already hashed, so just set it directly
            this.password = password;
        }
    }
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public List<Job> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(List<Job> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
