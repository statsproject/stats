package com.stats.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stats.domain.Grade;
import com.stats.dto.GradeDtoByCategory;
import com.stats.dto.GradeDtoByStudent;
import com.stats.service.GradeService;

@Service("jpaGradeService")
@Repository
@Transactional
public class GradeServiceImpl implements GradeService {
	@PersistenceContext
	private EntityManager entityManager;

	public List<GradeDtoByStudent> findAllGradesByName(String lastName,
			String firstName) {
		Query result = entityManager
				.createNamedQuery("Grade.findAllGradesByName");
		result.setParameter("last_name", lastName);
		result.setParameter("first_name", firstName);
		List<Grade> grades = result.getResultList();
		if (grades != null) {
			List<GradeDtoByStudent> dtoList = new LinkedList<GradeDtoByStudent>();
			for (Grade grade : grades) {
				dtoList.add(new GradeDtoByStudent(grade.getGrade(), grade
						.getAssignment().getName(), grade.getAssignment()
						.getCategory().getName()));
			}
			return dtoList;
		} else
			return null;
	}

	public List<GradeDtoByCategory> findAllAssignmentsByCategoryName(
			String categoryName) {
		Query result = entityManager
				.createNamedQuery("Grade.findAllAssignmentsByCategoryName");
		result.setParameter("categoryName", categoryName);
		List<Grade> grades = result.getResultList();
		if (grades != null) {
			List<GradeDtoByCategory> dtoList = new LinkedList<GradeDtoByCategory>();
			Map<Long, GradeDtoByCategory> dtoMap = new HashMap<Long, GradeDtoByCategory>();
			for (Grade grade : grades) {
				if (!dtoMap.containsKey(grade.getAssignment().getId())) {
					GradeDtoByCategory dto = new GradeDtoByCategory(grade
							.getAssignment().getName(), grade.getAssignment()
							.getDescription(), grade.getGrade());
					dtoMap.put(grade.getAssignment().getId(), dto);
				} else {
					Long key = grade.getAssignment().getId();
					Double avgGrade = (grade.getGrade() + dtoMap.get(key)
							.getAvgGrade()) / 2;
					GradeDtoByCategory dto = dtoMap.get(key);
					dto.setAvgGrade(avgGrade);
					dtoMap.put(key, dto);
				}
			}
			for (Map.Entry<Long, GradeDtoByCategory> entry : dtoMap.entrySet()) {
				dtoList.add(entry.getValue());
			}
			return dtoList;
		} else
			return null;
	}
}
