package com.homework.library.service;

import com.homework.library.entity.Author;
import com.homework.library.repos.AuthorRepo;
import com.homework.library.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public List<Author> getAll() {
        List<Author> authors = new ArrayList<>();
        authorRepo.findAll().forEach(authors::add);
        return authors;
    }

    @Override
    public Author getById(Long id) {
        return authorRepo.findById(id).get();
    }

    @Override
    public Author saveOrUpdate(Author author) {
        authorRepo.save(author);
        return author;
    }

    @Override
    public void delete(Long id) {
        authorRepo.deleteById(id);
    }
}
