package com.homework.library;

import com.homework.library.controler.AuthorController;
import com.homework.library.controler.BookController;
import com.homework.library.controler.UserController;
import com.homework.library.entity.Author;
import com.homework.library.entity.Book;
import com.homework.library.entity.User;
import com.homework.library.service.UserService;
import com.homework.library.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Executor {

    @Autowired
    private UserController userController;

    @Autowired(required = false)
    private AuthorController authorController;

    @Autowired(required = false)
    private BookController bookController;


    public void run(){

        Author author = new Author();
        author.setAuthorName("Oleg");

        Book book = new Book();
        book.setGenre("hooror");
        //book.setOwner(user);
        book.setTitle("ihak");

        User user = new User();
        user.setUserName("marik");
        //user.setBooks(Set.of(book));


        Set<Book> books = new HashSet<>();
        Set<Author> authors = new HashSet<>();

        books.add(book);
        authors.add(author);

        book.setAuthor(authors);
        author.setBooks(books);


        bookController.saveOrUpdate(book);
        authorController.saveOrUpdate(author);
        userController.saveOrUpdate(user);
    }

}
