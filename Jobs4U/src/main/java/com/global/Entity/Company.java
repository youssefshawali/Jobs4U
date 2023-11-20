package com.global.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Company")
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String webSite;
	private String mainLocation;
	private int size;
	private int foundedYear;
	private String about;
	private String specialists;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		email = email;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		webSite = webSite;
	}
	public String getMainLocation() {
		return mainLocation;
	}
	public void setMainLocation(String mainLocation) {
		mainLocation = mainLocation;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		size = size;
	}
	public int getFoundedYear() {
		return foundedYear;
	}
	public void setFoundedYear(int foundedYear) {
		foundedYear = foundedYear;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		about = about;
	}
	public String getSpecialists() {
		return specialists;
	}
	public void setSpecialists(String specialists) {
		specialists = specialists;
	}
	public Company(int id, String name, String email, String webSite, String mainLocation, int size, int foundedYear,
			String about, String specialists) {
		super();
		id = id;
		name = name;
		email = email;
		webSite = webSite;
		mainLocation = mainLocation;
		size = size;
		foundedYear = foundedYear;
		about = about;
		specialists = specialists;
	}
	public Company() {
		super();
	}
	
}
