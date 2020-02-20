package com.homework.library.repos;

import com.homework.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

    Author findByAuthorName(String authorName);

    @Query(value = "SELECT DISTINCT authorname FROM author", nativeQuery = true)
    Collection<String> getAllAuthor();
}
