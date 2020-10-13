package com.haulmont.testtask.view;

import com.haulmont.testtask.dbUtils.HsqldbConnectionUtil;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

@Theme(ValoTheme.THEME_NAME)
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(false);

        layout.addComponent(new Label("Hello world"));
        setContent(layout);



        HsqldbConnectionUtil hsqldbConnectionUtil = null;
        try {
            hsqldbConnectionUtil = HsqldbConnectionUtil.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        if (hsqldbConnectionUtil == null) {
            System.out.println("object is null");
        }



    }
}