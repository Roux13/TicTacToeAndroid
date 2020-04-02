package ru.job4j.tictactoe.view;

import ru.job4j.tictactoe.model.IField;
import ru.job4j.tictactoe.model.IPlayer;

public interface View {

    void display(IField field);

    void refresh();

    void showWinner(IPlayer player);

}
