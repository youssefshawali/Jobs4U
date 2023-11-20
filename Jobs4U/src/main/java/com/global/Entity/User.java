package com.global.Entity;

import java.awt.image.BufferedImage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private int age;
	//private BufferedImage ProfilePic;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		age = age;
	}
	
	public User(int id, String fname, String lname, String email, String password, int age, BufferedImage profilePic) {
		super();
		id = id;
		fname = fname;
		lname = lname;
		email = email;
		password = password;
		age = age;
		
	}
	public User() {
		super();
	}
	
	
}
