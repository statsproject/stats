package com.stats.service;

import java.util.List;

import com.stats.domain.Assignment;
import com.stats.dto.AssignmentDto;

public interface AssignmentService {
	public Assignment create(Assignment assignment);
	public Assignment update(Assignment assignment);
	
	public List<AssignmentDto> findAll();
	public List<AssignmentDto> findByName(String assignmentName);
	public AssignmentDto findById(Long id);
	public List<AssignmentDto> findByCategoryName(String categoryName);
}
