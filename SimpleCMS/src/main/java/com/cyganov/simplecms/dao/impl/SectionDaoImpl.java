package com.cyganov.simplecms.dao.impl;

import com.cyganov.simplecms.dao.BaseDao;
import com.cyganov.simplecms.dao.SectionDao;
import com.cyganov.simplecms.domain.Section;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 26.07.13
 * Time: 12:51
 */
@Repository
public class SectionDaoImpl extends BaseDao implements SectionDao{

	@Transactional
	@Override
	public Section getById(String id) {
		return (Section) getSession().get(Section.class, id);
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<Section> getChildrenByParent(Section section) {
		return getSession().createCriteria(Section.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.add(Restrictions.eq("parent", section)).list();
	}

	@Transactional
	@Override
	public void saveOrUpdate(Section section) {
		getSession().saveOrUpdate(section);
	}

	@Transactional
	@Override
	public void deleteById(String id) {
		Section section = (Section) getSession().load(Section.class, id);
		if (section != null) {
			getSession().delete(section);
		}
	}

	@Transactional
	@Override
	@SuppressWarnings("unchecked")
	public List<Section> getRootSections() {
		return getSession().createCriteria(Section.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.add(Restrictions.isNull("parent")).list();
	}

}
