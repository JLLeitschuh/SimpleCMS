package com.cyganov.simplecms.xml.parsers.impl;

import com.cyganov.simplecms.domain.Content;
import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.domain.Site;
import com.cyganov.simplecms.domain.XMLTagNames;
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
	private boolean rootParentFlag = false;

	public Site getSite(){
		Site site = new Site();
		site.setSectionList(sectionList);
		return site;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equals(XMLTagNames.SECTION)){
			currentSection = new Section();
			currentSection.setId(Integer.parseInt(attributes.getValue(XMLTagNames.ID)));
			currentSection.setName(attributes.getValue(XMLTagNames.NAME));
			currentSection.setPublished(Boolean.parseBoolean(attributes.getValue(XMLTagNames.PUBLISHED)));
			if (!rootParentFlag){
				sectionList.add(currentSection);
				rootParentFlag = true;
			}else {
				currentSection.setParent(lastParent);
				List<Section> childSectionList = lastParent.getChildren();
				childSectionList.add(currentSection);
				lastParent.setChildren(childSectionList);
			}
		}
		if (qName.equals(XMLTagNames.CHILDREN)){
			parents.push(currentSection);
			lastParent = currentSection;
			currentSection = null;
		}

		currentElement = qName;
		super.startElement(uri, localName, qName, attributes);

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals(XMLTagNames.SECTION)){
			currentSection = lastParent;
		}
		if (qName.equals(XMLTagNames.CHILDREN)){
			if (!parents.empty()){
				parents.pop();
				if (!parents.empty()){
					lastParent = parents.peek();
				}else{
					lastParent = null;
					rootParentFlag = false;
				}
			}
		}
		currentElement = "";
		super.endElement(uri, localName, qName);
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (currentElement.equals(XMLTagNames.BODY)){
			Content content = new Content();
			content.setBody(new String(ch, start, length));
			currentSection.setContent(content);
		}
	}


}