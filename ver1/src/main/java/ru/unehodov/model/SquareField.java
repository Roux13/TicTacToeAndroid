package ru.unehodov.model;

import java.util.Optional;

public class SquareField implements Field {

    private final int size;

    private final iFigure[][] figures;

    public SquareField(int size) {
        this.size = size;
        this.figures = new iFigure[size][size];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Optional<iFigure<?>> getFigure(iPoint p) {
        return Optional.ofNullable(figures[p.getX()][p.getY()]);
    }

    @Override
    public void setFigure(iFigure<?> figure, iPoint p) {
        figures[p.getX()][p.getY()] = figure;
    }
}
