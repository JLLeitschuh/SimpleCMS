package com.cyganov.simplecms.services;

import com.cyganov.simplecms.domain.Section;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 15.07.13
 * Time: 12:16
 */
public interface SiteService {

	public List<Section> getSectionList();

	public Section getSectionByName(String name);

	public void saveSection(Section section);

}
