package ru.nehodov.tictactoe.model;

import java.io.Serializable;
import java.util.Arrays;

public class SquareField implements Serializable, IField {

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
    public IFigure<?> getFigure(IPoint p) {
        return cells[p.getX()][p.getY()];
    }

    @Override
    public void setFigure(IFigure<?> figure, IPoint p) {
        cells[p.getX()][p.getY()] = figure;
    }

    @Override
    public void clearField() {
        for (IFigure<?>[] row : cells) {
            Arrays.fill(row, null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SquareField that = (SquareField) o;
        return Arrays.equals(cells, that.cells);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cells);
    }
}
