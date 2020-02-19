package com.homework.library.controler;

import com.homework.library.entity.User;
import com.homework.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserController {

    @Autowired
    private UserService userService;

    public List<User> getAll() {
        return userService.getAll();
    }

    public User getById(Long id) {
        return userService.getById(id);
    }

    public User saveOrUpdate(User user) {
        userService.saveOrUpdate(user);
        return user;
    }

    public void delete(Long id) {
        userService.delete(id);
    }

    public User getByUserName(String name){
        return userService.getByUserName(name);
    }
}
