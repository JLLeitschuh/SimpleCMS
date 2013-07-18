package com.cyganov.simplecms.services.impl;

import com.cyganov.simplecms.dao.SiteDao;
import com.cyganov.simplecms.dao.impl.XMLSiteDao;
import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.domain.Site;
import com.cyganov.simplecms.services.SiteService;

import java.util.List;

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
	public Section getSectionByName(String name) {
		List<Section> list = siteDao.getSite().getSectionList();
		return findSection(list, name);
	}

	@Override
	public void saveSection(Section section) {
		List<Section> list = siteDao.getSite().getSectionList();
		Section parent = findSection(list, section.getParent().getName());
		List<Section> children = parent.getChildren();
		children.add(section);
		parent.setChildren(children);
		Site site = new Site();
		site.setSectionList(list);
		siteDao.updateSite(site);
	}

	private Section findSection(List<Section> list, String name){
		Section result = null;
		for (Section section : list){
			if (section.getName().equals(name)){
				return section;
			}
			result = findSection(section.getChildren(), name);
			if (result != null){
				break;
			}
		}
		return result;
	}

}
