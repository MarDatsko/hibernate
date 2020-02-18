package com.homework.library.service;

import com.homework.library.entity.Author;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface AuthorService {

    List<Author> getAll();

    Author getById(Long id);

    Author saveOrUpdate(Author product);

    void delete(Long id);
}
