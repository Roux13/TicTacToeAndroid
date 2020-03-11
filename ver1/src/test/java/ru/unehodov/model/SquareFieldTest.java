package ru.unehodov.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareFieldTest {

    @Test
    public void setFigureWhenFieldSize1By1() {
        Point p = new SimplePoint(0, 0);
        int size = 1;
        Figure figure = Figure.X;
        Field field = new SquareField(size);
        field.setFigure(figure, p);
        Figure expected = figure;

        Figure actual = field.getFigure(p).get();

        assertThat(actual, is(expected));
    }

    @Test
    public void setFigureWhenFieldSize3By3AndFigureXInX2Y2() {
        Point p = new SimplePoint(2, 2);
        int size = 3;
        Figure figure = Figure.X;
        Field field = new SquareField(size);
        field.setFigure(figure, p);
        Figure expected = figure;

        Figure actual = field.getFigure(p).get();

        assertThat(actual, is(expected));
    }

    @Test
    public void getFigureWhenFieldSize3By3AndEmpty() {
        Point p = new SimplePoint(2, 2);
        int size = 3;
        Field field = new SquareField(size);
        boolean expected = true;

        boolean actual = field.getFigure(p).isEmpty();

        assertThat(actual, is(expected));
    }

    @Test
    public void getFigureWhenFieldSize10By10AndFigureOInX9Y9() {
        Point p = new SimplePoint(9, 9);
        int size = 10;
        Figure figure = Figure.O;
        Field field = new SquareField(size);
        field.setFigure(figure, p);
        Figure expected = figure;

        Figure actual = field.getFigure(p).get();

        assertThat(actual, is(expected));
    }
}