package com.cyganov.simplecms.services.impl;

import com.cyganov.simplecms.dao.SiteDao;
import com.cyganov.simplecms.dao.impl.XMLSiteDao;
import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.domain.Site;
import com.cyganov.simplecms.services.SiteService;

import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 15.07.13
 * Time: 12:20
 */
public class SiteServiceImpl implements SiteService{

	private SiteDao siteDao = new XMLSiteDao();

	@Override
	public List<Section> getSectionList() {
		return siteDao.getSite().getSectionList();
	}

	@Override
	public Section getSectionById(Integer id) {
		List<Section> list = siteDao.getSite().getSectionList();
		return findSection(list, id);
	}

	@Override
	public void saveSection(Section section) {
		List<Section> list = siteDao.getSite().getSectionList();

		if (section.getId() == null){
			section.setId(makeSectionId());
		} else {
			Section currentSection = findSection(list, section.getId());
			List<Section> children = currentSection.getChildren();
			for (Section child : children){
				child.setParent(section);
			}
			section.setChildren(children);
		}

		if (section.getParent() == null){
			list.add(section);
		} else {
			Section parent = findSection(list, section.getParent().getId());
			List<Section> children = parent.getChildren();
			Section copy = findSection(children, section.getId());
			if (copy != null){
				children.remove(copy);
			}
			children.add(section);
			parent.setChildren(children);

		}
		Site site = new Site();
		site.setSectionList(list);
		siteDao.updateSite(site);
	}

	private Section findSection(List<Section> list, Integer id){
		Section result = null;
		for (Section section : list){
			if (section.getId().equals(id)){
				return section;
			}
			result = findSection(section.getChildren(), id);
			if (result != null){
				break;
			}
		}
		return result;
	}

	private Integer makeSectionId(){
		return new Random().nextInt(Long.bitCount(System.currentTimeMillis()));//TODO fix: it has collisions
	}

}
