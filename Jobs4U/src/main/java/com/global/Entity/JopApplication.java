package com.global.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name = "JopApplication")
public class JopApplication {

	@Id
	private int userId;
	@Id
	private int jobId;
		
	
	public JopApplication(int userId, int jobId) {
		super();
		this.userId = userId;
		this.jobId = jobId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	
}
