package com.cyganov.simplecms.dao.impl;

import com.cyganov.simplecms.dao.UserDao;
import com.cyganov.simplecms.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 16.08.13
 * Time: 11:15
 */
@Repository
public class UserDaoImpl extends AbstractBaseDao implements UserDao {

	@Override
	public void delete(User user) {
		getSession().delete(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getList() {
		return getSession().createCriteria(User.class).list();
	}

	@Override
	public User getByName(String username) {
		return (User) getSession().get(User.class, username);
	}

	@Override
	public void saveOrUpdate(User user) {
		getSession().saveOrUpdate(user);
	}
}
