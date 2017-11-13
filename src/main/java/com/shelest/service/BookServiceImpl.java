package com.shelest.service;

import com.shelest.entity.Book;
import com.shelest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public List listAll() {
        return repository.listAll();
    }

    @Override
    public Book getById(long id) {
        return repository.getById(id);
    }

    @Override
    public void create(Book book) {
        repository.create(book);
    }

    @Override
    public void update(Book book, long id) {
        repository.update(book, id);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
