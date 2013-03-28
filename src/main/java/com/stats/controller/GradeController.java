package com.stats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stats.service.GradeService;

@Controller
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	protected GradeService gradeService;

	@RequestMapping(value = "/findAllGradesByName", method = RequestMethod.GET)
	public String findAllGradesByName(
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			Model uiModel) {
		uiModel.addAttribute("grades",gradeService.findAllGradesByName(lastName, firstName));
		return "/grade/studentstats";
	}
	@RequestMapping(value = "/findAllAssignmentsByCategoryName", method = RequestMethod.GET)
	public String findAllAssignmentsByCategoryName(
			@RequestParam("categoryName") String categoryName,
			Model uiModel) {
		uiModel.addAttribute("grades",gradeService.findAllAssignmentsByCategoryName(categoryName));
		return "/grade/categorystats";
	}

}
