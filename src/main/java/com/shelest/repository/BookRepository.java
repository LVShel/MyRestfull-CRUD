package com.shelest.repository;


import com.shelest.entity.Book;

import java.util.List;

public interface BookRepository {

    List listAll();

    Book getById(long id);

    void create(Book book);

    void update(Book book, long id);

    void delete(long id);
}
