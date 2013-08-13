package com.cyganov.simplecms.dao.impl;

import com.cyganov.simplecms.dao.SectionDao;
import com.cyganov.simplecms.domain.Section;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 26.07.13
 * Time: 12:51
 */
@Repository
public class SectionDaoImpl extends AbstractBaseDao implements SectionDao{

	@Override
	public Section getById(String id) {
		return (Section) getSession().get(Section.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Section> getChildrenByParent(Section section) {
		return getSession().createCriteria(Section.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.add(Restrictions.eq("parent", section)).list();
	}

	@Override
	public void saveOrUpdate(Section section) {
		getSession().saveOrUpdate(section);
	}

	@Override
	public void delete(Section section) {
		getSession().delete(section);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Section> getRootSections() {
		return getSession().createCriteria(Section.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.add(Restrictions.isNull("parent")).list();
	}

}
