package ru.unehodov.tictac.model;

import java.util.Optional;

public interface IField {

    int getSize();

    IFigure<?>[][] getCells();

    Optional<IFigure<?>> getFigure(IPoint p);

    void setFigure(IFigure<?> figure, IPoint p);

}
