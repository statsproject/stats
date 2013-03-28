package com.stats.dto;

import com.stats.domain.Category;
import com.stats.domain.Class;

public class AssignmentDto {
	private String name;
	private String description;
	private String clazz;
	private String category;
	public AssignmentDto(String name, String description, String clazz,
			String category) {
		super();
		this.name = name;
		this.description = description;
		this.clazz = clazz;
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
