package com.cyganov.simplecms.servlets;

import com.cyganov.simplecms.domain.Content;
import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.services.SiteService;
import com.cyganov.simplecms.services.impl.SiteServiceImpl;
import com.cyganov.simplecms.xml.XMLTagNames;

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

	private SiteService siteService = new SiteServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String parentId = req.getParameter("parentId");
		String sectionId = req.getParameter("sectionId");

		if (sectionId == null){
			req.setAttribute("section", new Section());

		} else {
			req.setAttribute("section", siteService.getSectionById(sectionId));
		}

		req.setAttribute("parentId", parentId);

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

		String id = request.getParameter(XMLTagNames.ID);
		if (!id.equals("")){
			section.setId(id);
		}
		section.setName(request.getParameter(XMLTagNames.NAME));
		section.setPublished(Boolean.parseBoolean(request.getParameter(XMLTagNames.PUBLISHED)));

		Content content = new Content();
		content.setBody(request.getParameter(XMLTagNames.BODY));
		section.setContent(content);

		Section parent = siteService.getSectionById(request.getParameter("parentId"));
		if (parent != null){
			section.setParent(parent);
		}

		return section;
	}

}
