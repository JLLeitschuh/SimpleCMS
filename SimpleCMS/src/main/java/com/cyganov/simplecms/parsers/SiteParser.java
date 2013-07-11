package com.cyganov.simplecms.parsers;

import com.cyganov.simplecms.domain.Site;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 11.07.13
 * Time: 11:38
 */
public interface SiteParser {

	public Site parse(String filePath);
}
