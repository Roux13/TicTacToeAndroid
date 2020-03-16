package ru.unehodov.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareFieldTest {

    @Test
    public void setFigureWhenFieldSize1By1() {
        IntPoint p = new Point(0, 0);
        int size = 1;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        IntFigure<?> figure = new FigureX();
        Field field = new SquareField(cells);
        field.setFigure(figure, p);
        IntFigure<?> expected = figure;

        IntFigure<?> actual = field.getFigure(p).get();

        assertThat(actual, is(expected));
    }

    @Test
    public void setFigureWhenFieldSize3By3AndFigureXInX2Y2() {
        IntPoint p = new Point(2, 2);
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        IntFigure<?> figure = new FigureX();
        Field field = new SquareField(cells);
        field.setFigure(figure, p);
        IntFigure<?> expected = figure;

        IntFigure<?> actual = field.getFigure(p).get();

        assertThat(actual, is(expected));
    }

    @Test
    public void getFigureWhenFieldSize3By3AndEmpty() {
        IntPoint p = new Point(2, 2);
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        boolean expected = true;

        boolean actual = field.getFigure(p).isEmpty();

        assertThat(actual, is(expected));
    }

    @Test
    public void getFigureWhenFieldSize10By10AndFigureOInX9Y9() {
        IntPoint p = new Point(9, 9);
        int size = 10;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        IntFigure<?> figure = new FigureO();
        Field field = new SquareField(cells);
        field.setFigure(figure, p);
        IntFigure<?> expected = figure;

        IntFigure<?> actual = field.getFigure(p).get();

        assertThat(actual, is(expected));
    }
}