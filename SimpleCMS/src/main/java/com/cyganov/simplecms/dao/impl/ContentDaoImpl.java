package com.cyganov.simplecms.dao.impl;

import com.cyganov.simplecms.dao.BaseDao;
import com.cyganov.simplecms.dao.ContentDao;
import com.cyganov.simplecms.domain.Content;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 30.07.13
 * Time: 12:23
 */
@Repository
public class ContentDaoImpl extends BaseDao implements ContentDao {

	@Transactional
	@Override
	public void saveOrUpdate(Content content) {
		getSession().saveOrUpdate(content);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) {
		Content content = (Content) getSession().load(Content.class, id);
		if (content != null) {
			getSession().delete(content);
		}
	}
}
