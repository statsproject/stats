package com.stats.service;

import java.util.List;

import com.stats.domain.Grade;
import com.stats.dto.GradeDtoByCategory;
import com.stats.dto.GradeDtoByStudent;

public interface GradeService {
	public List<GradeDtoByStudent> findAllGradesByName(String lastName, String firstName);
	public List<GradeDtoByCategory> findAllAssignmentsByCategoryName(String categoryName);
}
