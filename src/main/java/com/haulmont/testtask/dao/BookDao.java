package com.haulmont.testtask.dao;

import com.haulmont.testtask.dbUtils.HsqldbConnectionUtil;
import com.haulmont.testtask.domain.Book;

import java.util.List;
import java.util.Optional;

public class BookDao implements Dao<Book, Long> {

    private HsqldbConnectionUtil hsqldbConnectionUtil;

    public BookDao(HsqldbConnectionUtil hsqldbConnectionUtil) {
        this.hsqldbConnectionUtil = hsqldbConnectionUtil;
    }

    @Override
    public boolean save(Book entity) {
        return false;
    }

    @Override
    public boolean update(Book entity) {
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }

    @Override
    public Optional<Book> getById(Long aLong) {
        return Optional.empty();
    }

}
