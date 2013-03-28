package com.stats.service;

import java.util.List;

import com.stats.dto.ClassDtoByClassName;

public interface ClassService {

	public List<ClassDtoByClassName> findAllGradesByClassName(String className);

}
