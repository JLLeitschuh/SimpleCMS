package com.cyganov.simplecms.dao;

import com.cyganov.simplecms.domain.Section;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 26.07.13
 * Time: 12:50
 */
public interface SectionDao {

	public Section getById(String id);

	public List<Section> getChildrenByParent(Section section);

	public void saveOrUpdate(Section section);

	public void delete(Section section);

	public List<Section> getRootSections();

	public void update(Section section);

}
