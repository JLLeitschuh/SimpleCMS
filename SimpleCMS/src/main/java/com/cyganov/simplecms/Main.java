package com.cyganov.simplecms;

import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.domain.Site;
import com.cyganov.simplecms.parsers.SAXPars;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 10.07.13
 * Time: 12:45
 */
public class Main { //For Test

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SAXPars saxPars = new SAXPars();

		parser.parse(new File("src/main/resources/database.xml"), saxPars);
		Site site = saxPars.getSite();
		List<Section> list = site.getSectionList();
		for (Section section : list){
			System.out.println(section.toString());
		}

	}
}
