package com.global.Entity;

import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Name;
	private String Email;
	private String WebSite;
	private String MainLocation;
	private int Size;
	private int FoundedYear;
	private String About;
	private String Specialists;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getWebSite() {
		return WebSite;
	}
	public void setWebSite(String webSite) {
		WebSite = webSite;
	}
	public String getMainLocation() {
		return MainLocation;
	}
	public void setMainLocation(String mainLocation) {
		MainLocation = mainLocation;
	}
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public int getFoundedYear() {
		return FoundedYear;
	}
	public void setFoundedYear(int foundedYear) {
		FoundedYear = foundedYear;
	}
	public String getAbout() {
		return About;
	}
	public void setAbout(String about) {
		About = about;
	}
	public String getSpecialists() {
		return Specialists;
	}
	public void setSpecialists(String specialists) {
		Specialists = specialists;
	}
	public Company(int id, String name, String email, String webSite, String mainLocation, int size, int foundedYear,
			String about, String specialists) {
		super();
		Id = id;
		Name = name;
		Email = email;
		WebSite = webSite;
		MainLocation = mainLocation;
		Size = size;
		FoundedYear = foundedYear;
		About = about;
		Specialists = specialists;
	}
	public Company() {
		super();
	}
	
}
