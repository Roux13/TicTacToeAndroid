package ru.unehodov.model;

import java.util.Optional;

public interface Field {

    int getSize();

    Optional<IntFigure<?>> getFigure(IntPoint p);

    void setFigure(IntFigure<?> figure, IntPoint p);

}
