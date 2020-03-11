package ru.unehodov.view;

import ru.unehodov.model.Field;

public interface View {

    void display(Field field);

    void refresh();

}
