package com.cyganov.simplecms.controllers;

import com.cyganov.simplecms.dao.SiteDao;
import com.cyganov.simplecms.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	private SiteDao siteDao; //fix: service use

	@RequestMapping(value = "/site", method = RequestMethod.GET)
	public ModelAndView loadUsers() {

		ModelAndView modelAndView = new ModelAndView("site");
		List<Section> list = siteDao.getSite().getSectionList();
		modelAndView.addObject("rootSections", list);
		return modelAndView;
	}

}
