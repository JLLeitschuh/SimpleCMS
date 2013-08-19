package com.cyganov.simplecms.dao;

import com.cyganov.simplecms.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 16.08.13
 * Time: 11:15
 */
public interface UserDao {

	public void delete(User user);

	public List<User> getList();

	public User getByName(String username);

	public void saveOrUpdate(User user);

}
