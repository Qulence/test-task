package com.haulmont.testtask.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T, ID> {
    boolean save(T entity);

    boolean update(T entity);

    boolean deleteById(ID id);

    List<T> getAll();

    Optional<T> getById(ID id);
}