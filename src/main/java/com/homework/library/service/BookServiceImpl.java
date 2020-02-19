package com.homework.library.service;

import com.homework.library.entity.Book;
import com.homework.library.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        bookRepo.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book getById(Long id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public Book saveOrUpdate(Book book) {
        bookRepo.save(book);
        return book;
    }

    @Override
    public void delete(Long id) {
        bookRepo.deleteById(id);
    }
}
