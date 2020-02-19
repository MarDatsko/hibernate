package com.homework.library.controler;

import com.homework.library.entity.Author;
import com.homework.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public List<Author> getAll() {
        return new ArrayList<>(authorService.getAll());
    }

    public Author getById(Long id) {
        return authorService.getById(id);
    }

    public Author saveOrUpdate(Author author) {
        authorService.saveOrUpdate(author);
        return author;
    }

    public void delete(Long id) {
        authorService.delete(id);
    }
}
