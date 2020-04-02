package ru.job4j.tictactoe.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareFieldTest {

    @Test
    public void setFigureWhenFieldSize1By1() {
        IPoint p = new Point(0, 0);
        int size = 1;
        IFigure<String>[][] cells = new IFigure[size][size];
        IFigure<?> figure = new FigureX();
        IField field = new SquareField(cells);
        field.setFigure(figure, p);
        IFigure<?> expected = figure;

        IFigure<?> actual = field.getFigure(p);

        assertThat(actual, is(expected));
    }

    @Test
    public void setFigureWhenFieldSize3By3AndFigureXInX2Y2() {
        IPoint p = new Point(2, 2);
        int size = 3;
        IFigure<String>[][] cells = new IFigure[size][size];
        IFigure<?> figure = new FigureX();
        IField field = new SquareField(cells);
        field.setFigure(figure, p);
        IFigure<?> expected = figure;

        IFigure<?> actual = field.getFigure(p);

        assertThat(actual, is(expected));
    }

    @Test
    public void getFigureWhenFieldSize3By3AndEmpty() {
        IPoint p = new Point(2, 2);
        int size = 3;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        boolean expected = true;

        boolean actual = field.getFigure(p) == null;

        assertThat(actual, is(expected));
    }

    @Test
    public void getFigureWhenFieldSize10By10AndFigureOInX9Y9() {
        IPoint p = new Point(9, 9);
        int size = 10;
        IFigure<String>[][] cells = new IFigure[size][size];
        IFigure<?> figure = new FigureO();
        IField field = new SquareField(cells);
        field.setFigure(figure, p);
        IFigure<?> expected = figure;

        IFigure<?> actual = field.getFigure(p);

        assertThat(actual, is(expected));
    }
}