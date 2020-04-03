package ru.nehodov.tictactoe.model;

public interface IPlayer {

    String getName();

    IFigure<?> getFigure();

    boolean isCpu();

    void setCpu(boolean setCpu);
}
