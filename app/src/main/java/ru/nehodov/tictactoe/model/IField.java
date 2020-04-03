package ru.nehodov.tictactoe.model;

public interface IField {

    int getSize();

    IFigure<?>[][] getCells();

    IFigure<?> getFigure(IPoint p);

    void setFigure(IFigure<?> figure, IPoint p);

    void clearField();
}
