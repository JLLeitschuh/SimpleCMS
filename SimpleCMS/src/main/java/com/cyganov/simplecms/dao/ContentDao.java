package com.cyganov.simplecms.dao;

import com.cyganov.simplecms.domain.Content;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 30.07.13
 * Time: 12:22
 */
public interface ContentDao {

	public void saveOrUpdate(Content content);

	public void deleteById(Integer id);

}
