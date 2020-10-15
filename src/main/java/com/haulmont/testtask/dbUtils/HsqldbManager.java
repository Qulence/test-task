package com.haulmont.testtask.dbUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class HsqldbManager {

    private HsqldbConnectionUtil hsqldbConnectionUtil;

    public HsqldbManager(HsqldbConnectionUtil hsqldbConnectionUtil) {
        this.hsqldbConnectionUtil = hsqldbConnectionUtil;
    }

    public void executeQueryFromScript(String path, Charset charset) {
        try {
            String sql = readFile(path, charset);
            try (Connection connection = hsqldbConnectionUtil.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
