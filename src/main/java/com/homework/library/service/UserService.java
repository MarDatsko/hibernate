package com.homework.library.service;

import com.homework.library.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {

    List<User> getAll();

    User getById(Long id);

    User saveOrUpdate(User product);

    void delete(Long id);

    User getByUserName(String name);
}
