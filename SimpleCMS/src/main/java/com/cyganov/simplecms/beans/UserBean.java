package com.cyganov.simplecms.beans;

import com.cyganov.simplecms.domain.dto.UserDto;
import com.cyganov.simplecms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 11.09.13
 * Time: 14:52
 */

@Component
@Scope("session")
public class UserBean {

    @Autowired
    private UserService userService;

    private List<UserDto> userList;
    private UserDto user;

    @PostConstruct
    public void init(){
        userList = userService.getUsers();
        user = null;
    }

    public void userForEdit(UserDto user){
        this.user = user;
    }

    public void emptyUser(){
        user = new UserDto();
    }

    public void deleteUser(){
        userService.deleteByName(user.getUsername());
        init();
    }

    public void editUser(){
        userService.updateUser(user);
        init();
    }

    public List<UserDto> getUserList() {
        return userList;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
