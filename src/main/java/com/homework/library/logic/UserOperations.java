package com.homework.library.logic;

import com.homework.library.entity.Book;
import com.homework.library.entity.User;
import com.homework.library.service.AuthorService;
import com.homework.library.service.BookService;
import com.homework.library.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@NoArgsConstructor
@Component
public class UserOperations {

    public static User CURRENT_USER;

    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private AuthorService authorService;

    @Autowired(required = false)
    private BookService bookService;

    public boolean loginUser(String nickName) {
        boolean isLogin;
        if (userService.getByUserName(nickName) == null) {
            User user = new User(nickName);
            userService.saveOrUpdate(user);
            CURRENT_USER = userService.getByUserName(nickName);
            System.out.println("You have been added to the library list ");
            isLogin = true;
        } else {
            CURRENT_USER = userService.getByUserName(nickName);
            System.out.println("Welcome back to our library");
            isLogin = true;
        }
        return isLogin;
    }

    public void addBook(Book book) {
        bookService.saveOrUpdate(book);
        System.out.println("Book added successfully");
    }

    public void getBook(Long book_id) {
        Book book = bookService.getById(book_id);
        User user = userService.getById(CURRENT_USER.getId());
        Set<Book> bookSet = bookService.getAllUsersBookById(CURRENT_USER.getId());
        bookSet.add(book);
        user.setSetBook(bookSet);
        book.setOwner(user);
        userService.saveOrUpdate(user);
        bookService.saveOrUpdate(book);
        System.out.println("You successfully get book");
    }

    public void printFreeBook() {
        Collection<Book> allFreeBook = bookService.getAllFreeBook();
        for (Book item : allFreeBook) {
            System.out.println(item.getId() + " " + item.getTitle() + " " + item.getGenre());
        }
    }

    public boolean checksAuthorInDatabase(String authorName) {
        return authorService.findByAuthorName(authorName) != null;
    }

    public void printBookByGenre(String genre) {
        Collection<Book> allBooksByGenre = bookService.getAllBooksByGenre(genre);
        for (Book item : allBooksByGenre) {
            System.out.println(item.getId() + " " + item.getTitle() + " " + item.getGenre());
        }
    }

    public void printAllGenre() {
        Collection<Book> allGenre = bookService.getAllGenre();
        for (Book item : allGenre) {
            System.out.println(item.getGenre());
        }
    }

    public void printAllAuthor() {
        Collection<String> allAuthor = authorService.getAllAuthor();
        for (String item : allAuthor) {
            System.out.println(item);
        }
    }

    public void printBookByAuthor(String authorChoose) {
        Collection<Book> allBooksByAuthor = bookService.getAllBooksByAuthor(authorChoose);
        for (Book item : allBooksByAuthor) {
            System.out.println(item.getId() + " " + item.getTitle() + " " + item.getGenre());
        }
    }
}
