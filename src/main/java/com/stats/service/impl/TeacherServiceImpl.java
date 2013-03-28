package com.stats.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stats.domain.Grade;
import com.stats.domain.Teacher;
import com.stats.dto.GradeDtoByStudent;
import com.stats.dto.TeacherDto;
import com.stats.service.TeacherService;

@Service("jpaTeacherService")
@Repository
@Transactional
public class TeacherServiceImpl implements TeacherService {
	@PersistenceContext
	private EntityManager entityManager;

	public TeacherDto register(Teacher teacher) {
		try {
			entityManager.persist(teacher);
		} catch (Exception ex) {
			return null;
		}
		return new TeacherDto(teacher.getTeacherId(), teacher.getFirstName(),
				teacher.getLastName(), teacher.getEmail(),
				teacher.getCleverTeacherId());
	}

	public TeacherDto update(Teacher teacher) {
		try {
			entityManager.merge(teacher);
		} catch (Exception ex) {
			return null;
		}
		return new TeacherDto(teacher.getTeacherId(), teacher.getFirstName(),
				teacher.getLastName(), teacher.getEmail(),
				teacher.getCleverTeacherId());
	}

	public boolean delete(Teacher teacher) {
		try {
			entityManager.remove(teacher);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public boolean deleteById(Long id) {
		Query result = entityManager.createNamedQuery("Teacher.findById");
		result.setParameter("id", id);
		try {
			entityManager.remove(result.getSingleResult());
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public TeacherDto findById(Long id) {
		Query result = entityManager.createNamedQuery("Teacher.findById");
		result.setParameter("id", id);
		Teacher teacher = (Teacher) result.getSingleResult();
		if (teacher != null) {
			TeacherDto dto = new TeacherDto(teacher.getTeacherId(),
					teacher.getFirstName(), teacher.getLastName(),
					teacher.getEmail(), teacher.getCleverTeacherId());

			return dto;
		} else
			return null;
	}

	public List<TeacherDto> findByName(String lastName, String firstName) {
		Query result = entityManager.createNamedQuery("Teacher.findByName");
		result.setParameter("firstName", firstName);
		result.setParameter("lastName", lastName);
		List<Teacher> teachers = result.getResultList();
		if (teachers != null) {
			List<TeacherDto> dtoList = new LinkedList<TeacherDto>();
			for (Teacher teacher : teachers) {
				dtoList.add(new TeacherDto(teacher.getTeacherId(), teacher
						.getFirstName(), teacher.getLastName(), teacher
						.getEmail(), teacher.getCleverTeacherId()));
			}
			return dtoList;
		} else
			return null;
	}

	public List<TeacherDto> findAll() {
		Query result = entityManager.createNamedQuery("Teacher.findAll");
		List<Teacher> teachers = result.getResultList();
		if (teachers != null) {
			List<TeacherDto> dtoList = new LinkedList<TeacherDto>();
			for (Teacher teacher : teachers) {
				dtoList.add(new TeacherDto(teacher.getTeacherId(), teacher
						.getFirstName(), teacher.getLastName(), teacher
						.getEmail(), teacher.getCleverTeacherId()));
			}
			return dtoList;
		} else
			return null;
	}

	public TeacherDto login(String login, String password) {
		Query result = entityManager.createNamedQuery("Teacher.login");
		result.setParameter("login", login);
		result.setParameter("password", password);
		Teacher teacher = (Teacher) result.getSingleResult();
		if (teacher != null) {
			TeacherDto dto = new TeacherDto(teacher.getTeacherId(), teacher
						.getFirstName(), teacher.getLastName(), teacher
						.getEmail(), teacher.getCleverTeacherId());
			return dto;			
		} else
			return null;
	}

}
