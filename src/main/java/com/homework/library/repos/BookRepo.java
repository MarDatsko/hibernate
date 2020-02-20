package com.homework.library.repos;

import com.homework.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Set;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM public.books where owner_id= :id", nativeQuery = true)
    Set<Book> getAllUsersBookById(@Param("id") Long id);

    @Query(value = "SELECT * FROM public.books where owner_id is null", nativeQuery = true)
    Collection<Book> getAllFreeBook();

    @Query(value = "SELECT * FROM public.books where genre= :genre", nativeQuery = true)
    Collection<Book> getAllBooksByGenre(@Param("genre") String genre);

    @Query(value = "SELECT distinct genre,id, title, owner_id FROM books", nativeQuery = true)
    Collection<Book> getAllGenre();

    @Query(value = "SELECT * " +
            "FROM books " +
            "JOIN author_book ON author_book.book_id = books.id " +
            "JOIN author ON public.author.id = author_book.author_id " +
            "WHERE author.authorname= :authorname", nativeQuery = true)
    Collection<Book> getAllBooksByAuthor(@Param("authorname") String authorname);
}
