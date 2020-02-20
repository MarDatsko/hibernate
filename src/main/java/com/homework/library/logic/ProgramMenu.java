package com.homework.library.logic;

import com.homework.library.entity.Author;
import com.homework.library.entity.Book;
import com.homework.library.service.AuthorService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@NoArgsConstructor
@Component
public class ProgramMenu {

    @Autowired
    private UserOperations userOperations;

    @Autowired(required = false)
    private AuthorService authorService;

    @Autowired
    @Qualifier("scanner")
    private Scanner scanner;

    private boolean isAppRunning = true;

    public void runMenu() {
        System.out.println("Please enter your: Name");
        String nickName = scanner.nextLine();
        if (userOperations.loginUser(nickName)) {
            while (isAppRunning) {
                printMenu();
                String menuChoice = scanner.nextLine();
                switch (menuChoice) {
                    case "1":
                        getBook();
                        break;
                    case "2":
                        addBook();
                        break;
                    case "3":
                        findBookByGenre();
                        break;
                    case "4":
                        findBookByAuthor();
                        break;
                    case "0":
                        isAppRunning = false;
                        break;
                }
            }
        } else {
            System.out.println("You are not allowed to go to the library");
        }
    }

    public void printMenu() {
        System.out.println("1. Get book " +
                "\n2. Add book " +
                "\n3. Find book by genre " +
                "\n4. Find book by author " +
                "\n0. Exit");
    }

    public void getBook() {
        userOperations.printFreeBook();
        System.out.println("Choose book:  ");
        Long id = scanner.nextLong();
        userOperations.getBook(id);
    }

    public void addBook() {
        userOperations.addBook(createNewBook());
    }

    public void findBookByGenre() {
        userOperations.printAllGenre();
        System.out.println("Enter the genre of the book you want: ");
        String genreChoose = scanner.nextLine();
        userOperations.printBookByGenre(genreChoose);
    }

    public void findBookByAuthor() {
        userOperations.printAllAuthor();
        System.out.println("Enter the author you want: ");
        String authorChoose = scanner.nextLine();
        userOperations.printBookByAuthor(authorChoose);
    }

    public Book createNewBook() {
        Book book = new Book();
        System.out.println("Please enter book title: ");
        book.setTitle(scanner.nextLine());
        System.out.println("Please enter book genre: ");
        book.setGenre(scanner.nextLine());
        book.setAuthor(createAuthorForBook());
        return book;
    }

    public Set<Author> createAuthorForBook() {
        Set<Author> authorSet = new HashSet<>();
        boolean isMore = true;
        do {
            Author author = new Author();
            System.out.println("Please enter author' books: ");
            String authorName = scanner.nextLine();
            if (userOperations.checksAuthorInDatabase(authorName)) {
                authorSet.add(authorService.findByAuthorName(authorName));
            } else {
                author.setAuthorName(authorName);
                authorSet.add(author);
            }
            System.out.println("Book has another author?  y/n ");
            String choose = scanner.nextLine();
            isMore = choose.equals("y");
        } while (isMore);
        return authorSet;
    }
}
