package com.haulmont.testtask.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T, ID> {
    void save(T entity);

    void update(T entity);

    void deleteById(ID id);

    List<T> getAll();

    Optional<T> getById(ID id);
}