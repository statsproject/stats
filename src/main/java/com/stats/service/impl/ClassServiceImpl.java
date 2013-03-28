package com.stats.service.impl;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stats.domain.Class;
import com.stats.domain.Grade;
import com.stats.domain.Student;
import com.stats.dto.ClassDtoByClassName;
import com.stats.service.ClassService;

@Service("jpaClassService")
@Repository
@Transactional
public class ClassServiceImpl implements ClassService {
	@PersistenceContext
	private EntityManager entityManager;

	public List<ClassDtoByClassName> findAllGradesByClassName(String className) {
		Query result = entityManager
				.createNamedQuery("Class.findAllGradesByClassName");
		result.setParameter("className", className);
		com.stats.domain.Class clazz = (Class) result.getSingleResult();
		if (clazz != null) {
			List<ClassDtoByClassName> dtoList = new LinkedList<ClassDtoByClassName>();
			Set<Student> students = clazz.getStudents();
			Iterator<Student> iterator = students.iterator();

			while (iterator.hasNext()) {
				double avgGrade = 0;
				int numberOfGrades = 0;
				Student student = iterator.next();
				Set<Grade> grades = student.getGrades();
				Iterator<Grade> gradeIterator = grades.iterator();
				while (gradeIterator.hasNext()) {
					Grade grade = gradeIterator.next();
					if (grade.getAssignment().getClazz().getId() == clazz
							.getId()) {
						avgGrade = avgGrade + grade.getGrade();
						numberOfGrades++;
					}
				}
				if (numberOfGrades > 0) {
					avgGrade = avgGrade / numberOfGrades;
				}
				dtoList.add(new ClassDtoByClassName(student.getId(), student
						.getFirstName(), student.getLastName(), avgGrade));
			}
			return dtoList;
		} else
			return null;
	}

}
