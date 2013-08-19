package com.cyganov.simplecms.services;

import com.cyganov.simplecms.domain.dto.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 16.08.13
 * Time: 11:25
 */
@Transactional(readOnly = true)
public interface UserService {

	public void deleteByName(String username);

	public List<UserDto> getUsers();

	public void updateUser(UserDto userDto);

	public UserDto getUserByName(String username);

}
