package com.homework.library.service;

import com.homework.library.entity.Book;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface BookService {

    List<Book> getAll();

    Book getById(Long id);

    Book saveOrUpdate(Book product);

    void delete(Long id);

    Set<Book> getAllUsersBookById(Long id);

    Collection<Book> getAllFreeBook();

    Collection<Book> getAllBooksByGenre(String genre);

    Collection<Book> getAllGenre();

    Collection<Book> getAllBooksByAuthor(String authorName);

}
