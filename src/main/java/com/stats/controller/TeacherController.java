package com.stats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stats.domain.Teacher;
import com.stats.dto.TeacherDto;
import com.stats.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	protected TeacherService teacherService;

	@RequestMapping(value = "/findAllByName", method = RequestMethod.GET)
	public String findAllGradesByName(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, Model uiModel) {
		uiModel.addAttribute("teachers",
				teacherService.findByName(lastName, firstName));
		return "/teacher/listAll";
	}
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public String findAll(Model uiModel) {
		uiModel.addAttribute("teachers",
				teacherService.findAll());
		return "/teacher/listAll";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam("login") String login,
			@RequestParam("password") String password, Model uiModel) {
		TeacherDto dto = teacherService.login(login, password);
		if (dto != null) {
			uiModel.addAttribute("teacher", dto);
			return "/teacher/welcome";
		} else
			return "/teacher/notFound";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam("teacherId") String teacherId, 
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("login") String login,
			@RequestParam("password") String password, 
			@RequestParam("email") String email, 
			@RequestParam("cleverId") Long cleverId,
			Model uiModel) {
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		teacher.setFirstName(firstName);
		teacher.setLastName(lastName);
		teacher.setLogin(login);
		teacher.setPassword(password);
		teacher.setEmail(email);
		teacher.setCleverTeacherId(cleverId);
		
		TeacherDto dto = teacherService.register(teacher);
		if (dto != null) {
			uiModel.addAttribute("teacher", dto);
			return "/teacher/welcome";
		} else
			return "/teacher/error";
	}
}
