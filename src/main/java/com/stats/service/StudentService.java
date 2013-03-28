package com.stats.service;

import java.util.Date;
import java.util.List;

import com.stats.domain.Student;

public interface StudentService {
	
	public long addStudent(Student student);
	
	public Student getByStudentId(String id);
	public Student getWithDetailsByStudentId(String id);
	public Student getById(Long id);
	public Student getWithDetailsById(Long id);

	public boolean delete(Student student);
	
	public long update(Student student);
	
	public List<Student> getAll();
	public List<Student> getAllWithDetails();
	public List<Student> getAllByLastName(String lastName);
	public List<Student> getAllWithDetailsByLastName(String lastName);
	public List<Student> getAllByDob(Date dob);
	public List<Student> getAllWithDetailsByDob(Date dob);
	 
}
