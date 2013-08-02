package com.cyganov.simplecms.tags;

import com.cyganov.simplecms.domain.Section;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 01.08.13
 * Time: 14:03
 */
public class SectionTreeTag extends SimpleTagSupport {

	private int padding = 0;

	private List<Section> list;

	public void setList(List<Section> list) {
		this.list = list;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println(writeSections(list));
		super.doTag();
	}

	private String writeSections(List<Section> list) throws IOException {

		StringBuilder structure = new StringBuilder();
		for (Section section : list){
			Section root = section.getParent();
			String rootId = "";
			if (root != null){
				rootId = root.getId();
			}
			structure.append("<li style=\"padding-left:").append(padding).append("px;\"><span id=\"").append(section.getId())
					.append("\"class=\"close\" style=\"float:right; cursor: pointer;\">x</span>");
			structure.append("<a href=\"/mngt?rootId=").append(rootId).append("&sectionId=").append(section.getId())
					.append("\">").append(section.getName()).append("</a>");
			structure.append("</li>");
			if (section.getChildren().size() != 0){
				padding += 15;
				structure.append("<ul style=\"padding-left:").append(padding).append("px;\">");
				structure.append(writeSections(section.getChildren()));
				structure.append("</ul>");
			}

		}
		padding -= 15;
		return structure.toString();
	}
}
