package com.shelest.controller;

import com.shelest.entity.Book;
import com.shelest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BooksController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET, headers = "Accept=application/json")
    public List allBooks(){
        return bookService.listAll();
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Book getById(@PathVariable("id") long id){
        return bookService.getById(id);
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST, headers = "Accept=application/json")
    public void create(@RequestBody Book book){
        bookService.create(book);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void update(@PathVariable("id") long id, @RequestBody Book book){
        bookService.update(book, id);
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@PathVariable("id") long id){
        bookService.delete(id);
    }

}
