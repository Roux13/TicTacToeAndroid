package ru.unehodov.model;

import java.util.Optional;

public interface Field {

    int getSize();

    Optional<iFigure<?>> getFigure(iPoint p);

    void setFigure(iFigure<?> figure, iPoint p);

}
