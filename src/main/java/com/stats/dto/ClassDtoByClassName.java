package com.stats.dto;

public class ClassDtoByClassName {
	private String firstName;
	private String lastName;
	private Double avgGrade;
	private Long id;
	
	public ClassDtoByClassName(Long id,String firstName, String lastName, Double avgGrade) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.avgGrade = avgGrade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getAvgGrade() {
		return avgGrade;
	}
	public void setAvgGrade(Double avgGrade) {
		this.avgGrade = avgGrade;
	}
	
}
