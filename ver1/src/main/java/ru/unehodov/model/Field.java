package ru.unehodov.model;

import java.util.Optional;

public interface Field {

    int getSize();

    IntFigure<?>[][] getCells();

    Optional<IntFigure<?>> getFigure(IntPoint p);

    void setFigure(IntFigure<?> figure, IntPoint p);

}
