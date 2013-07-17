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

		String sectionName = req.getParameter("parentName");

		Section section = siteService.getSectionByName(sectionName);
		List<Section> sectionList = siteService.getSectionList();

		Section result = null;
		if (section != null){
			result = section;
		} else {
			if (sectionList.size() != 0){
				result = sectionList.get(0);
			}
		}

		req.setAttribute("mainSection", result);
		req.setAttribute("sections",sectionList);

		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/site.jsp");
		reqDispatcher.forward(req, resp);
	}
}
