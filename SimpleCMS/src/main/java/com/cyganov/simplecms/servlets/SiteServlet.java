package com.cyganov.simplecms.servlets;

import com.cyganov.simplecms.services.SiteService;
import com.cyganov.simplecms.services.impl.SiteServiceImpl;
import com.cyganov.simplecms.domain.Section;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 15.07.13
 * Time: 12:38
 */

public class SiteServlet extends HttpServlet {

	private SiteService siteService = new SiteServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String deleteId = req.getParameter("deleteId");
		if (deleteId != null){
			siteService.deleteSection(deleteId);
		}

		List<Section> sectionList = siteService.getSectionList();

		String rootId = req.getParameter("rootId");
		List<Section> sections = null;
		if (rootId != null){
			sections = siteService.getSectionById(rootId).getChildren();
		} else {
			if (sectionList.size() != 0){
				sections = sectionList.get(0).getChildren();
			}
		}

		String sectionId = req.getParameter("sectionId");
		Section section = null;
		if (sectionId != null){
			section = siteService.getSectionById(sectionId);
		} else {
			if (sectionList.size() != 0){
				section = sectionList.get(0);
			}
		}

		req.setAttribute("mainSection", section);
		req.setAttribute("rootSections", sectionList);
		req.setAttribute("sections", sections);

		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/site.jsp");
		reqDispatcher.forward(req, resp);
	}
}
