package com.cyganov.simplecms.xml.parsers.impl;

import com.cyganov.simplecms.domain.Content;
import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.domain.Site;
import com.cyganov.simplecms.domain.XMLTagNames;
import com.cyganov.simplecms.xml.parsers.SiteParser;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 11.07.13
 * Time: 10:21
 */
public class StAXSiteParser implements SiteParser {

	private String currentElement = "";
	private List<Section> sectionList = new ArrayList<Section>();
	private Section lastParent = null;
	private Section currentSection = null;
	private Stack<Section> parents= new Stack<Section>();
	private boolean rootParentFlag = false;

	@Override
	public Site parse(String filePath) {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		try {
			XMLEventReader reader = factory.createXMLEventReader(new FileReader(filePath));
			while(reader.hasNext()) {
				XMLEvent e = (XMLEvent) reader.next();
				processEvent(e);
			}

		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Site site = new Site();
		site.setSectionList(sectionList);
		return site;
	}

	private void processEvent(XMLEvent event){
		if (event.isStartElement()){
			QName qName = ((StartElement) event).getName();
			String localName = qName.getLocalPart();

			if (localName.equals(XMLTagNames.SECTION)){
				currentSection = new Section();

				Iterator iterator = ((StartElement) event).getAttributes();
				while (iterator.hasNext()) {
					Attribute attribute = (Attribute) iterator.next();
					String attributeName = attribute.getName().toString();
					if (attributeName.equals(XMLTagNames.NAME)) {
						currentSection.setName(attribute.getValue());
					}
					if (attributeName.equals(XMLTagNames.PUBLISHED)) {
						currentSection.setPublished(Boolean.parseBoolean(attribute.getValue()));
					}
				}

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
			if (localName.equals(XMLTagNames.CHILDREN)){
				parents.push(currentSection);
				lastParent = currentSection;
				currentSection = null;
			}

			currentElement = localName;
		}
		if (event.isEndElement()){
			QName qName = ((EndElement) event).getName();
			String localName = qName.getLocalPart();

			if (localName.equals(XMLTagNames.SECTION)){
				currentSection = lastParent;
			}
			if (localName.equals(XMLTagNames.CHILDREN)){
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

		}
		if (event.isCharacters()){
			if (currentElement.equals(XMLTagNames.BODY)){
				Content content = new Content();
				content.setBody(((Characters) event).getData());
				currentSection.setContent(content);
			}

		}

	}

}
