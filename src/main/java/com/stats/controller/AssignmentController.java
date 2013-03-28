package com.stats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stats.service.AssignmentService;

@Controller
@RequestMapping("/assignment")
public class AssignmentController {
	@Autowired
	protected AssignmentService assignmentService;

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String find(Model uiModel) {
		uiModel.addAttribute("assignments", assignmentService.findAll());
		return "/assignments/list";
	}

	@RequestMapping(value = "/findByName", method = RequestMethod.GET)
	public String findByName(
			@RequestParam("assignmentName") String assignmentName, Model uiModel) {
		uiModel.addAttribute("assignments",
				assignmentService.findByName(assignmentName));
		return "/assignments/list";
	}

	@RequestMapping(value = "/findByCategoryName", method = RequestMethod.GET)
	public String findByCategoryName(
			@RequestParam("categoryName") String categoryName, Model uiModel) {
		uiModel.addAttribute("assignments",
				assignmentService.findByCategoryName(categoryName));
		return "/assignments/list";
	}
}
