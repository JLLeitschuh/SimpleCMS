package com.cyganov.simplecms.converters;

import com.cyganov.simplecms.domain.Authorities;
import com.cyganov.simplecms.domain.User;
import com.cyganov.simplecms.domain.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 19.08.13
 * Time: 11:26
 */
public class UserConverter {

	public static UserDto UserToDto(User user){

		UserDto userDto = new UserDto();

		userDto.setUsername(user.getUsername());
		userDto.setEnabled(user.isEnabled());
		userDto.setPassword(user.getPassword());

		List<String> rolesList = new ArrayList<String>();
		for (Authorities authorities : user.getAuthorities()){
			rolesList.add(authorities.getAuthority());
		}
		userDto.setAuthorities(rolesList);

		return userDto;
	}

	public static User DtoToUser(UserDto userDto){

		User user = new User();
		user.setEnabled(userDto.isEnabled());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUsername());

		List<Authorities> authoritiesList = new ArrayList<Authorities>();
		for (String role : userDto.getAuthorities()){
			Authorities authorities = new Authorities();
			authorities.setAuthority(role);
			authoritiesList.add(authorities);
		}
		user.setAuthorities(authoritiesList);

		return user;
	}

}
