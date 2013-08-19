package com.cyganov.simplecms.services.impl;

import com.cyganov.simplecms.converters.UserConverter;
import com.cyganov.simplecms.dao.UserDao;
import com.cyganov.simplecms.domain.User;
import com.cyganov.simplecms.domain.dto.UserDto;
import com.cyganov.simplecms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 16.08.13
 * Time: 11:25
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Transactional (readOnly = false)
	@Override
	public void deleteByName(String username) {
		User user = userDao.getByName(username);

		if (user != null){
			userDao.delete(user);
		}
	}

	@Override
	public List<UserDto> getUsers() {
		List<UserDto> userDtoList = new ArrayList<UserDto>();

		List<User> list = userDao.getList();
		for (User user : list){
			userDtoList.add(UserConverter.UserToDto(user));
		}

		return userDtoList;
	}

	@Transactional (readOnly = false)
	@Override
	public void updateUser(UserDto userDto) {
		userDao.saveOrUpdate(UserConverter.DtoToUser(userDto));
	}

	@Override
	public UserDto getUserByName(String username) {
		return UserConverter.UserToDto(userDao.getByName(username));
	}
}
