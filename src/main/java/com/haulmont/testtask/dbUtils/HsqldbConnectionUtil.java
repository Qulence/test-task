package com.haulmont.testtask.dbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class HsqldbConnectionUtil {

    private final String user;
    private final String password;
    private final String url;

    private HsqldbConnectionUtil(String user, String password, String url) {
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public static HsqldbConnectionUtil newInstance() throws InstantiationException {
        try (InputStream inputStream =
                     HsqldbConnectionUtil.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            if (inputStream != null) {
                properties.load(inputStream);
                String dbName = properties.getProperty("db.name");
                String user = properties.getProperty("db.user");
                String password = properties.getProperty("db.password");
                String url = "jdbc:hsqldb:file:" + dbName ;
                if (dbName != null && user != null && password != null) {
                    try {
                        Class.forName("org.hsqldb.jdbc.JDBCDriver");
                        return new HsqldbConnectionUtil(user, password, url);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new InstantiationException();
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}