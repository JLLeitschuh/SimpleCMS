package com.cyganov.simplecms.dao.impl;

import com.cyganov.simplecms.dao.SiteDao;
import com.cyganov.simplecms.domain.Site;
import com.cyganov.simplecms.parsers.SiteParser;
import com.cyganov.simplecms.parsers.impl.StAXSiteParser;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 15.07.13
 * Time: 11:49
 */
public class XMLSiteDao implements SiteDao {

	public static final String filePath = "/database.xml";

	@Override
	public Site getSite() {
		String file = XMLSiteDao.class.getResource(filePath).getFile();
		SiteParser parser = new StAXSiteParser();
		return parser.parse(file);
	}

	@Override
	public void addSection() {

	}
}
