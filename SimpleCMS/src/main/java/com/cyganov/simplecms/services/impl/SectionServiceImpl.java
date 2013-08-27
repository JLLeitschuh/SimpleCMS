package com.cyganov.simplecms.services.impl;

import com.cyganov.simplecms.dao.ContentDao;
import com.cyganov.simplecms.dao.SectionDao;
import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.services.SectionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 29.07.13
 * Time: 14:00
 */
@Service
public class SectionServiceImpl implements SectionService {

	@Autowired
	SectionDao sectionDao;

	@Autowired
	ContentDao contentDao;

	@Override
	public Section getSectionById(String id) {
		return sectionDao.getById(id);
	}

	@Override
	public List<Section> getChildrenByParentId(String id) {
		Section section = sectionDao.getById(id);
		return sectionDao.getChildrenByParent(section);
	}

	@Transactional(readOnly = false)
	@Override
	public void updateSection(Section section, String parentId) {
		Section parent = null;
		if (parentId != null){
			parent = sectionDao.getById(parentId);
		}

		if (!StringUtils.isEmpty(section.getId())){
			sectionDao.update(refreshedSection(section, parent));
		} else {
			sectionDao.saveOrUpdate(newSection(section, parent));
		}
		section.setParent(parent);

	}

	@Transactional(readOnly = false)
	@Override
	public void deleteSectionById(String id) {
		Section section = sectionDao.getById(id);
		sectionDao.delete(section);
	}

	@Override
	public List<Section> getSections() {
		return sectionDao.getRootSections();
	}

	private Section newSection(Section section, Section parent){
		section.setParent(parent);
		if (parent != null){
			parent.getChildren().add(section);
		}
		section.setId(null);
		section.getContent().setSection(section);
		section.getContent().setId(null);
		return section;
	}

	private Section refreshedSection(Section section, Section parent){
		Section currentSection = sectionDao.getById(section.getId());
		currentSection.setParent(parent);
		currentSection.setName(section.getName());
		currentSection.setPublished(section.isPublished());
		currentSection.setDate(section.getDate());
		section.getContent().setSection(currentSection);
		currentSection.setContent(section.getContent());
		return currentSection;
	}
}
