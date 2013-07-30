package com.cyganov.simplecms.services;

import com.cyganov.simplecms.domain.Section;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 29.07.13
 * Time: 13:58
 */
public interface SectionService {

	public Section getSectionById(String id);

	public List<Section> getChildrenByParentId(String id);

	public void updateSection(Section section, String parentId);

	public void deleteSectionById(String id);

	public List<Section> getSections();

}
