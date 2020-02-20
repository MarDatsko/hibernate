package com.homework.library.service.impl;

import com.homework.library.entity.User;
import com.homework.library.repos.UserRepo;
import com.homework.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAll() {
        return new ArrayList<>(userRepo.findAll());
    }

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User saveOrUpdate(User user) {
        userRepo.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User getByUserName(String name) {
        return userRepo.findByUserName(name);
    }

}
