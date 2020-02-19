package com.homework.library.service;

import com.homework.library.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookService {

    List<Book> getAll();

    Book getById(Long id);

    Book saveOrUpdate(Book product);

    void delete(Long id);
}
