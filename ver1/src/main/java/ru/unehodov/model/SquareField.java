package ru.unehodov.model;

import java.util.Optional;

public class SquareField implements Field {

    private final int size;

    private final Figure[][] figures;

    public SquareField(int size) {
        this.size = size;
        this.figures = new Figure[size][size];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Optional<Figure> getFigure(Point p) {
        return Optional.ofNullable(figures[p.getX()][p.getY()]);
    }

    @Override
    public void setFigure(Figure figure, Point p) {
        figures[p.getX()][p.getY()] = figure;
    }
}
