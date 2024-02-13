package com.global.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String webSite;
	private String password;
	private int size;
	private int foundedYear;
	private String about;
	private String specialists;
	@Lob
	private byte[] profilePicture;
	@Lob
	private byte[] coverPicture;

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "main_location_id")
	private Location mainLocation;

	@JsonIgnore
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CompanyBranchLocation> branchLocations;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "industry_id")
	private Industry industry;

	public Company(int id, String name, String email, String webSite, String password, int size, int foundedYear,
			String about, String specialists, byte[] profilePicture, byte[] coverPicture, Location mainLocation,
			List<CompanyBranchLocation> branchLocations, Industry industry) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.webSite = webSite;
		this.password = password;
		this.size = size;
		this.foundedYear = foundedYear;
		this.about = about;
		this.specialists = specialists;
		this.mainLocation = mainLocation;
		this.profilePicture = profilePicture;
		this.coverPicture = coverPicture;
		this.branchLocations = branchLocations;
		this.industry = industry;
	}

	public Company() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getFoundedYear() {
		return foundedYear;
	}

	public void setFoundedYear(int foundedYear) {
		this.foundedYear = foundedYear;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getSpecialists() {
		return specialists;
	}

	public void setSpecialists(String specialists) {
		this.specialists = specialists;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public byte[] getCoverPicture() {
		return coverPicture;
	}

	public void setCoverPicture(byte[] coverPicture) {
		this.coverPicture = coverPicture;
	}

	public Location getMainLocation() {
		return mainLocation;
	}

	public void setMainLocation(Location mainLocation) {
		this.mainLocation = mainLocation;
	}

	public List<CompanyBranchLocation> getBranchLocations() {
		return branchLocations;
	}

	public void setBranchLocations(List<CompanyBranchLocation> branchLocations) {
		this.branchLocations = branchLocations;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

}
