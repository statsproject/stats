package com.stats.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stats.domain.Assignment;
import com.stats.dto.AssignmentDto;
import com.stats.service.AssignmentService;

@Service("jpaAssignmentService")
@Repository
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
	@PersistenceContext
	private EntityManager entityManager;

	public Assignment create(Assignment assignment) {
		try {
			entityManager.persist(assignment);
		} catch (Exception ex) {
			return null;
		}
		return assignment;

	}

	public Assignment update(Assignment assignment) {
		try {
			entityManager.merge(assignment);
		} catch (Exception ex) {
			return null;
		}
		return assignment;
	}

	public List<AssignmentDto> findAll() {
		List<Assignment> assignments = entityManager.createNamedQuery(
				"Assignment.find").getResultList();
		if (assignments != null && assignments.size() > 0) {
			List<AssignmentDto> dtoList = new LinkedList<AssignmentDto>();
			for (Assignment assignment : assignments) {
				dtoList.add(new AssignmentDto(assignment.getName(), assignment
						.getDescription(), assignment.getClazz().getName(),
						assignment.getCategory().getName()));
			}
			return dtoList;
		} else {
			return null;
		}
	}

	public List<AssignmentDto> findByName(String assignmentName) {
		Query result = entityManager
				.createNamedQuery("Assignment.findByName");
		result.setParameter("name", assignmentName);
		List<Assignment> assignments = result.getResultList();
		if (assignments != null && assignments.size() > 0) {
			List<AssignmentDto> dtoList = new LinkedList<AssignmentDto>();
			for (Assignment assignment : assignments) {
				dtoList.add(new AssignmentDto(assignment.getName(), assignment
						.getDescription(), assignment.getClazz().getName(),
						assignment.getCategory().getName()));
			}
			return dtoList;
		} else {
			return null;
		}
	}

	public AssignmentDto findById(Long id) {
		Query result = entityManager.createNamedQuery("Assignment.findById");
		result.setParameter("id", id);
		Assignment assignment = (Assignment) result.getSingleResult();
		if (assignment != null) {
			AssignmentDto dto = new AssignmentDto(assignment.getName(),
					assignment.getDescription(), assignment.getClazz()
							.getName(), assignment.getCategory().getName());
			return dto;
		} else {
			return null;
		}
	}

	public List<AssignmentDto> findByCategoryName(String categoryName) {
		Query result = entityManager
				.createNamedQuery("Assignment.findByCategoryName");
		result.setParameter("categoryName", categoryName);
		List<Assignment> assignments = result.getResultList();
		if (assignments != null && assignments.size() > 0) {
			List<AssignmentDto> dtoList = new LinkedList<AssignmentDto>();
			for (Assignment assignment : assignments) {
				dtoList.add(new AssignmentDto(assignment.getName(), assignment
						.getDescription(), assignment.getClazz().getName(),
						assignment.getCategory().getName()));
			}
			return dtoList;
		} else {
			return null;
		}
	}

}
