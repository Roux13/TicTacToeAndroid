package ru.unehodov.view;

import ru.unehodov.model.Field;
import ru.unehodov.model.IntPlayer;

public interface View {

    void display(Field field);

    void refresh();

    void showWinner(IntPlayer player);

}
