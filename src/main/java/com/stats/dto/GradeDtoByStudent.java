package com.stats.dto;

import java.io.Serializable;

public class GradeDtoByStudent implements Serializable {
	private Double grade;
	private String assignment;
	private String category;
	
	public GradeDtoByStudent(Double grade, String assignment, String category) {
		super();
		this.grade = grade;
		this.assignment = assignment;
		this.category = category;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
