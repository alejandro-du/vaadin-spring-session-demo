package com.example;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Alejandro Duarte.
 */
@SpringUI
@Theme(ValoTheme.THEME_NAME)
public class VaadinUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        setContent(new Button("Test", e -> e.getButton().setCaption("Ok")));
    }

}
