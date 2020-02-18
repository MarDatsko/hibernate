package com.homework.library.service;

import com.homework.library.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface BookService {

    List<Book> getAll();

    Book getById(Long id);

    Book saveOrUpdate(Book product);

    void delete(Long id);
}
