package com.cyganov.simplecms;

import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.domain.Site;
import com.cyganov.simplecms.parsers.impl.DOMSiteParser;
import com.cyganov.simplecms.parsers.impl.SAXSiteParser;
import com.cyganov.simplecms.parsers.SiteParser;
import com.cyganov.simplecms.parsers.impl.StAXSiteParser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 10.07.13
 * Time: 12:45
 */
public class Main { //For Test

	public static void main(String[] args) {

		SiteParser parser = new SAXSiteParser();
		Site site = parser.parse("src/main/resources/database.xml");

		SiteParser parser2 = new StAXSiteParser();
		Site site2 = parser2.parse("src/main/resources/database.xml");

		SiteParser parser3 = new DOMSiteParser();
		Site site3 = parser3.parse("src/main/resources/database.xml");

		List<Section> list = site.getSectionList();
		List<Section> list2 = site2.getSectionList();
		List<Section> list3 = site3.getSectionList();

		System.out.println("Done!");

	}
}
