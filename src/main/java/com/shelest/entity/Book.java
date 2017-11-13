package com.shelest.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    long id;
    String author;
    String header;

    public Book() {
    }

    public Book(String author, String header) {
        this.author = author;
        this.header = header;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
