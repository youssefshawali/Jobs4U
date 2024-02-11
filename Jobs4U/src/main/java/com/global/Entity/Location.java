package com.global.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String streetName;
	private int floornumber;
	private int apartmentNumber;
	private int buildingNumber;
	private int zipcode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City city;



	public City getCity() {
		return city;
	}


	public void setCity(City city) {
		this.city = city;
	}





	public Location(int id, String streetName, int floornumber, int apartmentnumber, int buildingnumber, int zipcode,
			City city) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.floornumber = floornumber;
		this.apartmentNumber = apartmentnumber;
		this.buildingNumber = buildingnumber;
		this.zipcode = zipcode;
		this.city = city;
	}


	public Location() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getStreetName() {
		return streetName;
	}


	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}


	public int getFloornumber() {
		return floornumber;
	}


	public void setFloornumber(int floornumber) {
		this.floornumber = floornumber;
	}


	public int getApartmentnumber() {
		return apartmentNumber;
	}


	public void setApartmentnumber(int apartmentnumber) {
		apartmentnumber = apartmentnumber;
	}


	public int getBuildingnumber() {
		return buildingNumber;
	}


	public void setBuildingnumber(int buildingnumber) {
		this.buildingNumber = buildingnumber;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}


	
	

}
