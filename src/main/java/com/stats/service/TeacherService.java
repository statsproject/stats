package com.stats.service;

import java.util.List;

import com.stats.domain.Teacher;
import com.stats.dto.TeacherDto;

public interface TeacherService {
	
	public TeacherDto login(String password, String login);
	
	public TeacherDto register(Teacher teacher);
	
	public TeacherDto update(Teacher teacher);
	
	public boolean delete(Teacher teacher);
	public boolean deleteById(Long id);
	
	public TeacherDto findById(Long id);
	public List<TeacherDto> findByName(String lastName,String firstName);
	public List<TeacherDto> findAll();
}
