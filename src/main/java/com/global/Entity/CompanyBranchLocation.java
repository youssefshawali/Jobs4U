package com.global.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "company_branches")
public class CompanyBranchLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "location_id")
	private Location location;

	@Column(name = "branch_name")
	private String branchName;

	public CompanyBranchLocation(int id, Company company, Location location, String branchName) {
		super();
		this.id = id;
		this.company = company;
		this.location = location;
		this.branchName = branchName;
	}

	
	public CompanyBranchLocation() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}
