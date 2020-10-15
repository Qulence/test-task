package com.haulmont.testtask.dao;

import com.haulmont.testtask.dbUtils.HsqldbConnectionUtil;
import com.haulmont.testtask.domain.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AuthorDao implements Dao<Author, Long> {

    private HsqldbConnectionUtil hsqldbConnectionUtil;

    public AuthorDao(HsqldbConnectionUtil hsqldbConnectionUtil) {
        this.hsqldbConnectionUtil = hsqldbConnectionUtil;
    }

    @Override
    public void save(Author entity) {

    }

    @Override
    public void update(Author entity) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Author> getAll() {
        List<Author> result = new LinkedList<>();
        try (Connection connection = hsqldbConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM AUTHOR");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String patronymic = resultSet.getString(4);
                result.add(new Author(id, firstname, lastname, patronymic));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Optional<Author> getById(Long aLong) {
        return Optional.empty();
    }
}
