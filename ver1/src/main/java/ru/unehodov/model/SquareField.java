package ru.unehodov.model;

import java.util.Optional;

public class SquareField implements Field {

    private final IntFigure<?>[][] cells;

    public SquareField(IntFigure<?>[][] cells) {
        this.cells = cells;
    }

    @Override
    public int getSize() {
        return this.cells.length;
    }

    @Override
    public IntFigure<?>[][] getCells() {
        return this.cells;
    }

    @Override
    public Optional<IntFigure<?>> getFigure(IntPoint p) {
        return Optional.ofNullable(cells[p.getX()][p.getY()]);
    }

    @Override
    public void setFigure(IntFigure<?> figure, IntPoint p) {
        cells[p.getX()][p.getY()] = figure;
    }
}
