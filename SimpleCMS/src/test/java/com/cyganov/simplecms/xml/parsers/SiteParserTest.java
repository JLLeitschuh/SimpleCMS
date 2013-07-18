package com.cyganov.simplecms.xml.parsers;

import com.cyganov.simplecms.domain.Content;
import com.cyganov.simplecms.domain.Section;

import com.cyganov.simplecms.domain.Site;
import com.cyganov.simplecms.xml.parsers.impl.DOMSiteParser;
import com.cyganov.simplecms.xml.parsers.impl.SAXSiteParser;
import com.cyganov.simplecms.xml.parsers.impl.StAXSiteParser;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 11.07.13
 * Time: 14:16
 */
public class SiteParserTest {

	private static final String FILE_PATH = "src/test/resources/test-database.xml";

	@Test
	public void SAXSiteParserTest(){

		SiteParser siteParser = new SAXSiteParser();
		Site site = siteParser.parse(FILE_PATH);
		checkListData(site.getSectionList(), makeListSections());
	}

	@Test
	public void StAXSiteParserTest(){

		SiteParser siteParser = new StAXSiteParser();
		Site site = siteParser.parse(FILE_PATH);
		checkListData(site.getSectionList(), makeListSections());
	}

	@Test
	public void DOMSiteParserTest(){

		SiteParser siteParser = new DOMSiteParser();
		Site site = siteParser.parse(FILE_PATH);
		checkListData(site.getSectionList(), makeListSections());
	}

	private void checkListData(List<Section> currentList, List<Section> parsedList){

		assertTrue("wrong list size", currentList.size() == parsedList.size());

		for (int i = 0; i < currentList.size(); i++){

			Section currentSection = currentList.get(i);
			Section parsedSection = parsedList.get(i);

			assertEquals("wrong section id", currentSection.getId(), parsedSection.getId());
			assertEquals("wrong section name", currentSection.getName(), parsedSection.getName());
			assertTrue("wrong section published", currentSection.isPublished() == parsedSection.isPublished());
			assertEquals("wrong section content", currentSection.getContent(), parsedSection.getContent());
			if (currentSection.getParent() != null && parsedSection.getParent() != null){
				assertEquals("wrong section parent", currentSection.getParent().getName(), parsedSection.getParent().getName());
			}
			if (currentSection.getChildren() != null && currentSection.getChildren() != null){
				checkListData(currentSection.getChildren(), parsedSection.getChildren());
			}
		}

	}

	private List<Section> makeListSections(){

		List<Section> resultList = new ArrayList<Section>();

		List<Section> rootChildren = new ArrayList<Section>();
		List<Section> rootChildren2 = new ArrayList<Section>();

		Section rootSection = new Section(0, null, "menu1", true, null, rootChildren);
		Section rootSection2 = new Section(4, null, "menu2", true, null, rootChildren2);
		resultList.add(rootSection);
		resultList.add(rootSection2);

		List<Section> children2 = new ArrayList<Section>();

		Content content = new Content("its body of section 1.1!");
		Content content2 = new Content("its body of section 1.2!");
		Section section = new Section(1, content, "section11", false, rootSection, null);
		Section section2 = new Section(2, content2, "section12", true, rootSection, children2);
		rootChildren.add(section);
		rootChildren.add(section2);

		content = new Content("its last body!");
		section = new Section(3, content, "section121", true, section2, null);
		children2.add(section);

		content = new Content("its body of section 2.1!");
		section = new Section(5, content, "section21", true, rootSection2, null);
		rootChildren2.add(section);

		return resultList;
	}


}
