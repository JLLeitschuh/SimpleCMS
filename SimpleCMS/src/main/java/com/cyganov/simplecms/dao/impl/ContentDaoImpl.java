package com.cyganov.simplecms.dao.impl;

import com.cyganov.simplecms.dao.ContentDao;
import com.cyganov.simplecms.domain.Content;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 30.07.13
 * Time: 12:23
 */
@Repository
public class ContentDaoImpl extends AbstractBaseDao implements ContentDao {

	@Override
	public void saveOrUpdate(Content content) {
		getSession().saveOrUpdate(content);
	}

	@Override
	public void delete(Content content) {
		getSession().delete(content);
	}
}
