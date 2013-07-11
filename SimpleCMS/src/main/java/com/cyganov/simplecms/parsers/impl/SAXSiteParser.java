package com.cyganov.simplecms.parsers.impl;

import com.cyganov.simplecms.domain.Site;
import com.cyganov.simplecms.parsers.SiteParser;
import com.cyganov.simplecms.parsers.SiteXMLHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 11.07.13
 * Time: 10:21
 */
public class SAXSiteParser implements SiteParser {

	@Override
	public Site parse(String filePath) {

		SiteXMLHandler siteXMLHandler = new SiteXMLHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(new File(filePath), siteXMLHandler);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		return siteXMLHandler.getSite();
	}

}
