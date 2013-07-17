package com.cyganov.simplecms.servlets;

import com.cyganov.simplecms.domain.Content;
import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.services.SiteService;
import com.cyganov.simplecms.services.impl.SiteServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 16.07.13
 * Time: 11:53
 */
public class AddSectionServlet extends HttpServlet {

	SiteService siteService = new SiteServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String parentName = req.getParameter("parentName");
		req.setAttribute("parentName", parentName);

		req.setAttribute("section", new Section());

		RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/addSection.jsp");
		reqDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		siteService.saveSection(getSection(req));

		resp.sendRedirect(resp.encodeRedirectURL("/site"));
	}

	private Section getSection(HttpServletRequest request){
		Section section = new Section();
		section.setName(request.getParameter("name"));
		section.setPublished(Boolean.parseBoolean(request.getParameter("published")));
		Content content = new Content();
		content.setBody(request.getParameter("body"));
		section.setContent(content);
		section.setParent(siteService.getSectionByName(request.getParameter("parentName")));
		return section;
	}

}
