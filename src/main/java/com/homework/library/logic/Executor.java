package com.homework.library.logic;

import com.homework.library.entity.Author;
import com.homework.library.entity.Book;
import com.homework.library.entity.User;
import com.homework.library.service.AuthorService;
import com.homework.library.service.BookService;
import com.homework.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Executor {

    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private AuthorService authorService;

    @Autowired(required = false)
    private BookService bookService;

    @Autowired(required = false)
    private UserOperations userOperations;

    @Autowired
    private ProgramMenu programMenu;

    public void fillDatabase() {
        Author miguelDeCervantes = new Author("Miguel de Cervantes");
        Author jamesJoyce = new Author("James Joyce");
        Author markTwain = new Author("Mark Twain");
        Author homer = new Author("Homer");
        Author williamShakespeare = new Author("William Shakespeare");
        Author testAuthor = new Author("Test Author");

        Book romeo = new Book("Romeo and Juliet", "classic");
        Book game = new Book("A Game of Thrones", "fantasy");
        Book holmes = new Book("Sherlock Holmes", "crime");
        Book demons = new Book("Angels and Demons", "mystery");
        Book jobs = new Book("Steve Jobs", "biography");
        Book testBook = new Book("Test Book", "Test book");

        User chaplin = new User("Charlie Chaplin");
        User lee = new User("Lee Curtis");
        User marlon = new User("Marlon Brando");

        miguelDeCervantes.setBooks(Set.of(game));
        jamesJoyce.setBooks(Set.of(game, holmes));
        markTwain.setBooks(Set.of(jobs));
        williamShakespeare.setBooks(Set.of(romeo));
        homer.setBooks(Set.of(demons, game, holmes));

        testAuthor.setBooks(Set.of(testBook));

        game.setAuthor(Set.of(miguelDeCervantes, jamesJoyce, homer));
        game.setOwner(chaplin);
        romeo.setAuthor(Set.of(williamShakespeare));
        romeo.setOwner(chaplin);
        holmes.setAuthor(Set.of(jamesJoyce, homer));
        holmes.setOwner(lee);
        demons.setAuthor(Set.of(homer));
        demons.setOwner(marlon);
        jobs.setAuthor(Set.of(markTwain));
        jobs.setOwner(marlon);

        testBook.setAuthor(Set.of(testAuthor));

        chaplin.setSetBook(Set.of(game, romeo));
        lee.setSetBook(Set.of(holmes));
        marlon.setSetBook(Set.of(demons, jobs));

        userService.saveOrUpdate(chaplin);
        userService.saveOrUpdate(lee);
        userService.saveOrUpdate(marlon);

        bookService.saveOrUpdate(game);
        bookService.saveOrUpdate(romeo);
        bookService.saveOrUpdate(holmes);
        bookService.saveOrUpdate(demons);
        bookService.saveOrUpdate(jobs);

        bookService.saveOrUpdate(testBook);
        authorService.saveOrUpdate(testAuthor);

        authorService.saveOrUpdate(miguelDeCervantes);
        authorService.saveOrUpdate(jamesJoyce);
        authorService.saveOrUpdate(markTwain);
        authorService.saveOrUpdate(homer);
        authorService.saveOrUpdate(williamShakespeare);

        programMenu.runMenu();
    }
}
