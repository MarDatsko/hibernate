package com.homework.library.service.impl;

import com.homework.library.entity.Book;
import com.homework.library.repos.BookRepo;
import com.homework.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(bookRepo.findAll());
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

    @Override
    public Set<Book> getAllUsersBookById(Long id){
        return new HashSet<>(bookRepo.getAllUsersBookById(id));
    }

    @Override
    public Collection<Book> getAllFreeBook(){
        return new HashSet<>(bookRepo.getAllFreeBook());
    }

    @Override
    public Collection<Book> getAllBooksByGenre(String genre) {
        return new HashSet<>(bookRepo.getAllBooksByGenre(genre));
    }

    @Override
    public Collection<Book> getAllGenre() {
        return new ArrayList<>(bookRepo.getAllGenre());
    }

    @Override
    public Collection<Book> getAllBooksByAuthor(String authorName) {
        return new ArrayList<>(bookRepo.getAllBooksByAuthor(authorName));
    }
}
