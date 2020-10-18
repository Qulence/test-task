package com.haulmont.testtask.view;

import com.haulmont.testtask.dao.AuthorDao;
import com.haulmont.testtask.dbUtils.HsqldbConnectionUtil;
import com.haulmont.testtask.domain.Author;
import com.vaadin.ui.*;

import java.util.List;

public class AuthorView extends VerticalLayout {

    private HsqldbConnectionUtil hsqldbConnectionUtil;
    private AuthorDao authorDao;
    private List<Author> authorList;

    private Grid<Author> authorGrid = new Grid<>(Author.class);
    private HorizontalLayout horizontalButtonsLayout = new HorizontalLayout();
    private Button add = new Button("Добавить");
    private Button update = new Button("Изменить");
    private Button delete = new Button("Удалить");

    public AuthorView() {
        setHeightFull();
        try {
            hsqldbConnectionUtil = HsqldbConnectionUtil.newInstance();
            authorDao = new AuthorDao(hsqldbConnectionUtil);
            authorList = authorDao.getAll();

            //author grid
            authorGrid.setItems(authorList);
            authorGrid.setColumnOrder("id", "firstname", "patronymic", "lastname");

            authorGrid.setSizeFull();

            // buttons
            add.setStyleName("friendly");
            update.setStyleName("primary");
            delete.setStyleName("danger");

            //horizontalButttonsLayout
            horizontalButtonsLayout.setHeightFull();

        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        addComponent(authorGrid);
        horizontalButtonsLayout.addComponent(add);
        horizontalButtonsLayout.addComponent(update);
        horizontalButtonsLayout.addComponent(delete);
        addComponent(horizontalButtonsLayout);

        setExpandRatio(authorGrid, 0.95f);
        setExpandRatio(horizontalButtonsLayout, 0.05f);
    }

}
