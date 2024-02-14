package com.global.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "City")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "government_id")
	private Government government;

	// @OneToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "location_id")
	@JsonIgnore
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Location> locations;
	// private Location location;

	public City() {
		super();
	}

	public City(int id, String name, Government government, List<Location> locations) {
		super();
		this.id = id;
		this.name = name;
		this.government = government;
		this.locations = locations;
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

	public Government getGovernment() {
		return government;
	}

	public void setGovernment(Government government) {
		this.government = government;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

}
