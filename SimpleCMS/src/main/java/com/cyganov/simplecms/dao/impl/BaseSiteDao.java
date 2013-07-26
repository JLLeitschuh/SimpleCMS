package com.cyganov.simplecms.dao.impl;

import com.cyganov.simplecms.dao.BaseDao;
import com.cyganov.simplecms.dao.SiteDao;
import com.cyganov.simplecms.domain.Section;
import com.cyganov.simplecms.domain.Site;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 24.07.13
 * Time: 11:30
 */
@Repository
public class BaseSiteDao extends BaseDao implements SiteDao{

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public Site getSite() {

		List<Section> list = getSession().createCriteria(Section.class).list(); //to fix
		Site site = new Site();
		site.setSectionList(list);
		return site;

	}

	@Transactional
	@Override
	public void updateSite(Site site) {

	}
}
