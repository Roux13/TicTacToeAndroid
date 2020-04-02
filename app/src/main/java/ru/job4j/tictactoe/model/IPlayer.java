package ru.job4j.tictactoe.model;

public interface IPlayer {

    String getName();

    IFigure<?> getFigure();

    boolean isCpu();
}
