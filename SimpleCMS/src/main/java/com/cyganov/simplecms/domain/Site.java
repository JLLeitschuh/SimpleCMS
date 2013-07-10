package com.cyganov.simplecms.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 10.07.13
 * Time: 13:20
 */
public class Site {

	private List<Section> sectionList;

	public List<Section> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<Section> sectionList) {
		this.sectionList = sectionList;
	}
}
