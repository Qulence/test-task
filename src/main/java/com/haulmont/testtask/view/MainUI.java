package com.haulmont.testtask.view;

import com.haulmont.testtask.dbUtils.HsqldbConnectionUtil;
import com.haulmont.testtask.dbUtils.HsqldbManager;
import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;

@Theme(ValoTheme.THEME_NAME)
public class MainUI extends UI {

    private AuthorView authorView = new AuthorView();

    @Override
    protected void init(VaadinRequest request) {

        try {
            HsqldbConnectionUtil hsqldbConnectionUtil = HsqldbConnectionUtil.newInstance();
            HsqldbManager hsqldbManager = new HsqldbManager(hsqldbConnectionUtil);
            Connection connection = hsqldbConnectionUtil.getConnection();
            connection.close();
            //todo relative paths
            hsqldbManager.executeQueryFromScript("C:\\Users\\Qulence\\IdeaProjects\\test-task\\dbCreate.sql", StandardCharsets.UTF_8);
            hsqldbManager.executeQueryFromScript("C:\\Users\\Qulence\\IdeaProjects\\test-task\\dbInsert.sql", StandardCharsets.UTF_8);
        } catch (InstantiationException | SQLException e) {
            e.printStackTrace();
        }

        setSizeFull();

        authorView.setMargin(false);

        setContent(authorView);
    }
}


