package com.stats.dto;

import java.io.Serializable;

public class GradeDtoByCategory implements Serializable {
	private String assignmentName;
	private String assignmentDescription;
	private Double avgGrade;
	
	public GradeDtoByCategory(String assignmentName,
			String assignmentDescription, Double avgGrade) {
		super();
		this.assignmentName = assignmentName;
		this.assignmentDescription = assignmentDescription;
		this.avgGrade = avgGrade;
	}
	public String getAssignmentName() {
		return assignmentName;
	}
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}
	public String getAssignmentDescription() {
		return assignmentDescription;
	}
	public void setAssignmentDescription(String assignmentDescription) {
		this.assignmentDescription = assignmentDescription;
	}
	public Double getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(Double avgGrade) {
		this.avgGrade = avgGrade;
	}

	
	
}
