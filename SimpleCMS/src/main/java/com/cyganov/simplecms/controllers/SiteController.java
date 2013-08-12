package com.cyganov.simplecms.controllers;

import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 24.07.13
 * Time: 11:06
 */
@Controller
public class SiteController {

	@Autowired
	private SectionService sectionService;

	@RequestMapping(value = "/login")
	public String login() {
		return "redirect:/site?rootId=&sectionId=";
	}

	@RequestMapping(value = "/mngt", method = RequestMethod.GET)
	public ModelAndView loadSiteTree(@RequestParam("rootId") String rootId, @RequestParam("sectionId") String sectionId) {
		ModelAndView modelAndView = new ModelAndView("mngt");
		List<Section> sectionList = sectionService.getSections();

		Section section = null;
		if (sectionId.equals("")){
			//default values
			section = sectionList.get(0);
		} else {
			section = sectionService.getSectionById(sectionId);
		}

		modelAndView.addObject("section", section);
		modelAndView.addObject("sections", sectionList);
		return modelAndView;
	}

	@RequestMapping(value = "/mngt", method = RequestMethod.POST)
	public String editSection(@ModelAttribute("section") Section section, @ModelAttribute("rootId") String rootId) {
		sectionService.updateSection(section, rootId);
		return "redirect:/mngt?rootId="+rootId+"&sectionId="+section.getId();
	}

	@RequestMapping(value = "/site", method = RequestMethod.GET)
	public ModelAndView loadSite(@RequestParam("rootId") String rootId, @RequestParam("sectionId") String sectionId) {
        ModelAndView modelAndView = new ModelAndView("site");

		List<Section> sectionList = sectionService.getSections();

		Section section = null;
		List<Section> sections = null;
		if (rootId.equals("") && sectionId.equals("")){
			//default values
			section = sectionList.get(0);
			sections = sectionService.getChildrenByParentId(section.getId());
		} else {
			section = sectionService.getSectionById(sectionId);
			sections = sectionService.getChildrenByParentId(rootId);
		}

		modelAndView.addObject("sections", sections);
		modelAndView.addObject("mainSection", section);
		modelAndView.addObject("rootSections", sectionList);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addSection(@RequestParam("parentId") String parentId, @RequestParam("sectionId") String sectionId) {

		ModelAndView modelAndView = new ModelAndView("addSection");

		Section section = null;
		if (sectionId.equals("")){
			section = new Section();
		} else {
			section = sectionService.getSectionById(sectionId);
		}

		modelAndView.addObject("parentId", parentId);
		modelAndView.addObject("section", section);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addSection(@ModelAttribute("section") Section section, @ModelAttribute("parentId") String parentId) {
		sectionService.updateSection(section, parentId);
		return "redirect:/site?rootId=&sectionId=";
	}

	@RequestMapping(value = "/{page}/delete", method = RequestMethod.GET)
	public String deleteSection(@RequestParam("id") String id, @PathVariable("page") String page) {
		sectionService.deleteSectionById(id);
		return "redirect:/"+page+"?rootId=&sectionId=";
	}

}