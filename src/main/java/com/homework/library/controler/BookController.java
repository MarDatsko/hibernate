package com.homework.library.controler;

import com.homework.library.entity.Book;
import com.homework.library.service.BookService;
import com.homework.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookController {

    @Autowired
    @Qualifier("book")
    private BookService bookService;

    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        bookService.getAll().forEach(books::add);
        return books;
    }

    public Book getById(Long id) {
        return bookService.getById(id);
    }

    public Book saveOrUpdate(Book book) {
        bookService.saveOrUpdate(book);
        return book;
    }

    public void delete(Long id) {
        bookService.delete(id);
    }
}
