package com.stats.dto;

import java.io.Serializable;

public class TeacherDto implements Serializable{
	private String teacherId;
	private String firstName;
	private String lastName;
	private String email;
	private Long cleverTeacherId;
	
	public TeacherDto(String teacherId, String firstName, String lastName,
			String email, Long cleverTeacherId) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cleverTeacherId = cleverTeacherId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getCleverTeacherId() {
		return cleverTeacherId;
	}
	public void setCleverTeacherId(Long cleverTeacherId) {
		this.cleverTeacherId = cleverTeacherId;
	}
	
}
