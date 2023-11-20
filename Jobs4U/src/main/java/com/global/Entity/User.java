package com.global.Entity;

import java.awt.image.BufferedImage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Fname;
	private String Lname;
	private String Email;
	private String Password;
	private int Age;
	//private BufferedImage ProfilePic;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	public User(int id, String fname, String lname, String email, String password, int age, BufferedImage profilePic) {
		super();
		Id = id;
		Fname = fname;
		Lname = lname;
		Email = email;
		Password = password;
		Age = age;
		
	}
	public User() {
		super();
	}
	
	
}
