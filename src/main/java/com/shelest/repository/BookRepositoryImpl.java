package com.shelest.repository;

import com.shelest.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private SessionFactory sessionFactory;


    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List listAll() {
        return getSession().createCriteria(Book.class).list();
    }

    @Override
    public Book getById(long id) {
        return getSession().get(Book.class, id);
    }

    @Override
    public void create(Book book) {
        getSession().save(book);
    }

    @Override
    public void update(Book book, long id) {
        Session session = getSession();
        Book updated = session.load(Book.class, id);
        updated.setAuthor(book.getAuthor());
        updated.setHeader(book.getHeader());
        session.flush();
    }

    @Override
    public void delete(long id) {
        Session session = getSession();
        Book deleted = session.load(Book.class, id);
        getSession().delete(deleted);
    }
}
