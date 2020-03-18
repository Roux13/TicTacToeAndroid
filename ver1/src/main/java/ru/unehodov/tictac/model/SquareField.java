package ru.unehodov.tictac.model;

import java.util.Optional;

public class SquareField implements IField {

    private final IFigure<?>[][] cells;

    public SquareField(IFigure<?>[][] cells) {
        this.cells = cells;
    }

    @Override
    public int getSize() {
        return this.cells.length;
    }

    @Override
    public IFigure<?>[][] getCells() {
        return this.cells;
    }

    @Override
    public Optional<IFigure<?>> getFigure(IPoint p) {
        return Optional.ofNullable(cells[p.getX()][p.getY()]);
    }

    @Override
    public void setFigure(IFigure<?> figure, IPoint p) {
        cells[p.getX()][p.getY()] = figure;
    }
}
