
package com.stats.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stats.domain.Student;
import com.stats.service.StudentService;

@Service("jpaStudentService")
@Repository
@Transactional
public class StudentServiceImpl implements StudentService {

	@PersistenceContext
	private EntityManager entityManager;

	public long addStudent(Student student) {
		entityManager.persist(student);
		return student.getId();
	}

	public Student getByStudentId(String id) {
		Query result = entityManager
				.createNamedQuery("Student.findByStudentId");
		result.setParameter("student_id", id);
		return (Student) result.getSingleResult();
	}

	public Student getWithDetailsByStudentId(String id) {
		Query result = entityManager
				.createNamedQuery("Student.findWithDetailsByStudentId");
		result.setParameter("student_id", id);
		return (Student) result.getSingleResult();
	}

	public Student getById(Long id) {
		Query result = entityManager.createNamedQuery("Student.findById");
		result.setParameter("id", id);
		return (Student) result.getSingleResult();
	}

	public Student getWithDetailsById(Long id) {
		Query result = entityManager
				.createNamedQuery("Student.findWithDetailsById");
		result.setParameter("id", id);
		return (Student) result.getSingleResult();
	}

	public boolean delete(Student student) {
		entityManager.remove(student);
		return true;
	}

	public long update(Student student) {
		entityManager.merge(student);
		return student.getId();
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAll() {
		return entityManager.createNamedQuery("Student.findAll")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllWithDetails() {
		return entityManager.createNamedQuery("Student.findAllWithDetails")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllByLastName(String lastName) {
		Query result = entityManager
				.createNamedQuery("Student.findAllByLastName");
		result.setParameter("last_name", lastName);
		return result.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllWithDetailsByLastName(String lastName) {
		Query result = entityManager
				.createNamedQuery("Student.findAllWithDetailsByLastName");
		result.setParameter("last_name", lastName);
		return result.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllByDob(Date dob) {
		Query result = entityManager.createNamedQuery("Student.findAllByDob");
		 result.setParameter("dob", dob, TemporalType.DATE);
		 return result.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Student> getAllWithDetailsByDob(Date dob) {
		Query result = entityManager.createNamedQuery("Student.findAllWithDetailsByDob");
		 result.setParameter("dob", dob, TemporalType.DATE);
		 return result.getResultList();
	}

}