package com.global.Entity;

import java.util.List;

import org.hibernate.annotations.ValueGenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String JobTitle;
	private String Description;
	private String Requirments;
	
	
}
