package com.shelest.service;

import com.shelest.entity.Book;

import java.util.List;

public interface BookService {

    List listAll();

    Book getById(long id);

    void create(Book book);

    void update(Book book, long id);

    void delete(long id);
}
