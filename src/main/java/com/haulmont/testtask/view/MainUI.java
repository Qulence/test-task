package com.haulmont.testtask.view;

import com.haulmont.testtask.dao.AuthorDao;
import com.haulmont.testtask.dbUtils.HsqldbConnectionUtil;
import com.haulmont.testtask.dbUtils.HsqldbManager;
import com.haulmont.testtask.domain.Author;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Theme(ValoTheme.THEME_NAME)
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(false);

        layout.addComponent(new Label("Hello world"));
        setContent(layout);


        try {
            HsqldbConnectionUtil hsqldbConnectionUtil = HsqldbConnectionUtil.newInstance();
            HsqldbManager hsqldbManager = new HsqldbManager(hsqldbConnectionUtil);
            //todo relative paths
            hsqldbManager.executeQueryFromScript("C:\\Users\\Qulence\\IdeaProjects\\test-task\\dbCreate.sql", StandardCharsets.UTF_8);
            hsqldbManager.executeQueryFromScript("C:\\Users\\Qulence\\IdeaProjects\\test-task\\dbInsert.sql", StandardCharsets.UTF_8);

            List<Author> authorList = new AuthorDao(hsqldbConnectionUtil).getAll();
            for (Author author : authorList) {
                System.out.println(author);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}