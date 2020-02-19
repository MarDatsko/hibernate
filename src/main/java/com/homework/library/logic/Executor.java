package com.homework.library.logic;

import com.homework.library.controler.AuthorController;
import com.homework.library.controler.BookController;
import com.homework.library.controler.UserController;
import com.homework.library.entity.Author;
import com.homework.library.entity.Book;
import com.homework.library.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class Executor {

    @Autowired(required = false)
    private UserController userController;

    @Autowired(required = false)
    private AuthorController authorController;

    @Autowired(required = false)
    private BookController bookController;

    @Autowired(required = false)
    private UserOperations userOperations;

    public void fillDatabase() {
        Author miguelDeCervantes = new Author("Miguel de Cervantes");
        Author jamesJoyce = new Author("James Joyce");
        Author markTwain = new Author("Mark Twain");
        Author homer = new Author("Homer");
        Author williamShakespeare = new Author("William Shakespeare");

        Book romeo = new Book("Romeo and Juliet", "classic");
        Book game = new Book("A Game of Thrones", "fantasy");
        Book holmes = new Book("Sherlock Holmes", "crime ");
        Book demons = new Book("Angels and Demons", "mystery");
        Book jobs = new Book("Steve Jobs", "biography");

        User chaplin = new User("Charlie Chaplin");
        User lee = new User("Lee Curtis");
        User marlon = new User("Marlon Brando");

        miguelDeCervantes.setBooks(Set.of(game));
        jamesJoyce.setBooks(Set.of(game, holmes));
        markTwain.setBooks(Set.of(jobs));
        williamShakespeare.setBooks(Set.of(romeo));
        homer.setBooks(Set.of(demons, game, holmes));

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

        chaplin.setSetBook(Set.of(game, romeo));
        lee.setSetBook(Set.of(holmes));
        marlon.setSetBook(Set.of(demons, jobs));

        userController.saveOrUpdate(chaplin);
        userController.saveOrUpdate(lee);
        userController.saveOrUpdate(marlon);

        bookController.saveOrUpdate(game);
        bookController.saveOrUpdate(romeo);
        bookController.saveOrUpdate(holmes);
        bookController.saveOrUpdate(demons);
        bookController.saveOrUpdate(jobs);

        authorController.saveOrUpdate(miguelDeCervantes);
        authorController.saveOrUpdate(jamesJoyce);
        authorController.saveOrUpdate(markTwain);
        authorController.saveOrUpdate(homer);
        authorController.saveOrUpdate(williamShakespeare);


        userOperations.loginUser("Lee Curtis");
    }
}
