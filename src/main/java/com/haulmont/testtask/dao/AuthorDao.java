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
    public boolean save(Author author) {
        try (Connection connection = hsqldbConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO AUTHOR(FIRSTNAME, LASTNAME, PATRONYMIC) VALUES (?,?,?)")) {
            preparedStatement.setString(1, author.getFirstname());
            preparedStatement.setString(2, author.getLastname());
            preparedStatement.setString(3, author.getPatronymic());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Author author) {
        //todo test
        if (getById(author.getId()).isPresent()) {
            try (Connection connection = hsqldbConnectionUtil.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "UPDATE AUTHOR SET FIRSTNAME = (?), LASTNAME= (?), PATRONYMIC = (?) WHERE ID = (?)")) {
                preparedStatement.setString(1, author.getFirstname());
                preparedStatement.setString(2, author.getLastname());
                preparedStatement.setString(3, author.getPatronymic());
                preparedStatement.setLong(4, author.getId());
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean deleteById(Long id) {
        //todo test
        if (getById(id).isPresent()) {
            try (Connection connection = hsqldbConnectionUtil.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "DELETE FROM AUTHOR WHERE ID = (?)")) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Author> getAll() {
        List<Author> result = new LinkedList<>();
        try (Connection connection = hsqldbConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AUTHOR");
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
    public Optional<Author> getById(Long id) {
        try (Connection connection = hsqldbConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM AUTHOR WHERE ID = (?)")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long authorId = resultSet.getLong(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String patronymic = resultSet.getString(4);
                return Optional.of(new Author(authorId, firstname, lastname, patronymic));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
