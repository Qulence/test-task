package com.haulmont.testtask.dao;

import com.haulmont.testtask.dbUtils.HsqldbConnectionUtil;
import com.haulmont.testtask.domain.Genre;

import java.util.List;
import java.util.Optional;

public class GenreDao implements Dao<Genre, Long> {

    private HsqldbConnectionUtil hsqldbConnectionUtil;

    public GenreDao(HsqldbConnectionUtil hsqldbConnectionUtil) {
        this.hsqldbConnectionUtil = hsqldbConnectionUtil;
    }

    @Override
    public boolean save(Genre entity) {
        return false;
    }

    @Override
    public boolean update(Genre entity) {
        return false;
    }

    @Override
    public boolean deleteById(Long aLong) {
        return false;
    }

    @Override
    public List<Genre> getAll() {
        return null;
    }

    @Override
    public Optional<Genre> getById(Long aLong) {
        return Optional.empty();
    }
}
