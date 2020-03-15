package ru.unehodov.model;

import java.util.Optional;

public class SquareField implements Field {

    private final int size;

    private final IntFigure[][] figures;

    public SquareField(int size) {
        this.size = size;
        this.figures = new IntFigure[size][size];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Optional<IntFigure<?>> getFigure(IntPoint p) {
        return Optional.ofNullable(figures[p.getX()][p.getY()]);
    }

    @Override
    public void setFigure(IntFigure<?> figure, IntPoint p) {
        figures[p.getX()][p.getY()] = figure;
    }
}
