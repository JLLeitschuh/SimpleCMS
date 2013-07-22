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
 * Date: 17.07.13
 * Time: 12:05
 */
public class SectionDisplayTag extends SimpleTagSupport {

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
		String structure = "";
		for (Section section : list){
			if (section.isPublished()){
				Section root = section;
				while (root.getParent() != null){
					root = root.getParent();
				}

				structure +="<li><span id=\""+section.getId()+"\"class=\"close\" style=\"float:right; cursor: pointer;\">x</span>";
				structure += "<a href=\"/site?rootId="+root.getId()+"&sectionId="+section.getId()+"\">"+section.getName()+"</a>";
				if (section.getChildren().size() != 0){
					structure +="<ul>";
					structure += writeSections(section.getChildren());
					structure +="</ul>";
				}
				structure +="</li>";
			}else{
				structure +="<li  class=\"ui-state-disabled\"><span id=\""+section.getId()+"\"class=\"close\" style=\"float:right; cursor: pointer;\">x</span>";
				structure += "<a href=\"#"+section.getId()+"\">"+section.getName()+"</a></li>";
			}
		}
		return structure;
	}
}