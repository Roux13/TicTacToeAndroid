package ru.unehodov.tictac.model;

public interface IPlayer {

    String getName();

    IFigure<?> getFigure();

    boolean isCpu();
}
