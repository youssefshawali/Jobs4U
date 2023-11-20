package com.global.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Location")
public class Location {

	private double Latitude;
	private double Longitude;
	public double getLatitude() {
		return Latitude;
	}
	public void setLatitude(double latitude) {
		Latitude = latitude;
	}
	public double getLongitude() {
		return Longitude;
	}
	public void setLongitude(double longitude) {
		Longitude = longitude;
	}
	public Location(double latitude, double longitude) {
		super();
		Latitude = latitude;
		Longitude = longitude;
	}
	public Location() {
		super();
	}
}
