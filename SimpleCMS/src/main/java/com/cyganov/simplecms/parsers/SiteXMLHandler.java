package com.cyganov.simplecms.parsers;

import com.cyganov.simplecms.domain.Content;
import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.domain.Site;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 10.07.13
 * Time: 10:28
 */

public class SiteXMLHandler extends DefaultHandler {

	private String currentElement = "";
	private List<Section> sectionList = new ArrayList<Section>();
	private Section lastParent = null;
	private Section currentSection = null;
	private Stack<Section> parents= new Stack<Section>();

	public Site getSite(){
		Site site = new Site();
		site.setSectionList(sectionList);
		return site;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equals("section")){
			currentSection = new Section();
			currentSection.setName(attributes.getValue("name"));
			currentSection.setPublished(Boolean.parseBoolean(attributes.getValue("published")));
			sectionList.add(currentSection);
		}
		if (qName.equals("children")){
			parents.push(currentSection);
			lastParent = currentSection;
			currentSection = null;
		}

		currentElement = qName;
		super.startElement(uri, localName, qName, attributes);

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("section")){
			if (lastParent != null){
				List<Section> sections = lastParent.getChildren();
				sections.add(currentSection);
				lastParent.setChildren(sections);
				currentSection.setParent(lastParent);
			}
			currentSection = lastParent;
		}
		if (qName.equals("children")){
			if (!parents.empty()){
				parents.pop();
				if (!parents.empty()){
					lastParent = parents.peek();
				}else{
					lastParent = null;
				}
			}
		}
		currentElement = "";
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (currentElement.equals("body")){
			Content content = new Content();
			content.setBody(new String(ch, start, length));
			content.setSection(currentSection);
			currentSection.setContent(content);
		}
	}


}