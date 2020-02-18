package com.homework.library.controler;

import com.homework.library.entity.User;
import com.homework.library.service.UserService;
import com.homework.library.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserController {

    @Autowired
    @Qualifier("user")
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
}
