package ru.unehodov.model;

import java.util.Optional;

public interface Field {

    int getSize();

    Optional<Figure> getFigure(Point p);

    void setFigure(Figure figure, Point p);

}
