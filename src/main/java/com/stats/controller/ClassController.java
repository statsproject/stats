package com.stats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stats.service.ClassService;
@Controller
@RequestMapping("/class")
public class ClassController {
	@Autowired
	protected ClassService classService;
	
	@RequestMapping(value = "/findAllGradesByClassName", method = RequestMethod.GET)
	public String findAllGradesByClassName(
			@RequestParam("className") String className,
			Model uiModel) {
		uiModel.addAttribute("students",classService.findAllGradesByClassName(className));
		return "/class/classstats";
	}
}
