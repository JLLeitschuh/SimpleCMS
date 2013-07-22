package com.cyganov.simplecms.xml.writer;

import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.domain.Site;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 18.07.13
 * Time: 12:02
 */
public class XMLSiteWriter {

	public void writeFile(Site site, String filePath){

		List<Section> sections = site.getSectionList();

		Document document = DocumentHelper.createDocument();
		Element root = document.addElement( "site" );
		root.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance")
				.addAttribute("xsi:noNamespaceSchemaLocation", "schema.xsd");

		createDocument(sections, root);

		try {
			XMLWriter writer = new XMLWriter(new FileWriter( filePath ));
			writer.write( document );
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void createDocument(List<Section> sections, Element element){

		for (Section section : sections){
			Element currentElement = element.addElement("section").addAttribute("id", section.getId())
					.addAttribute("name", section.getName())
					.addAttribute("published",Boolean.toString(section.isPublished()));

			if (section.getContent() != null){
				currentElement.addElement("content").addElement("body").addText(section.getContent().getBody());
			}

			if (section.getChildren().size() != 0){
				Element children = currentElement.addElement("children");
				createDocument(section.getChildren(), children);
			}

		}
	}

}
