package ru.unehodov.tictac.view;

import ru.unehodov.tictac.model.IField;
import ru.unehodov.tictac.model.IPlayer;

public interface View {

    void display(IField field);

    void refresh();

    void showWinner(IPlayer player);

}
