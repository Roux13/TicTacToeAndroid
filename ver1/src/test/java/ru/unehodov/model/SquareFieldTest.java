package ru.unehodov.model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareFieldTest {

    @Test
    public void setFigureWhenFieldSize1By1() {
        iPoint p = new Point(0, 0);
        int size = 1;
        iFigure<?> figure = new FigureX();
        Field field = new SquareField(size);
        field.setFigure(figure, p);
        iFigure<?> expected = figure;

        iFigure<?> actual = field.getFigure(p).get();

        assertThat(actual, is(expected));
    }

    @Test
    public void setFigureWhenFieldSize3By3AndFigureXInX2Y2() {
        iPoint p = new Point(2, 2);
        int size = 3;
        iFigure<?> figure = new FigureX();
        Field field = new SquareField(size);
        field.setFigure(figure, p);
        iFigure<?> expected = figure;

        iFigure<?> actual = field.getFigure(p).get();

        assertThat(actual, is(expected));
    }

    @Test
    public void getFigureWhenFieldSize3By3AndEmpty() {
        iPoint p = new Point(2, 2);
        int size = 3;
        Field field = new SquareField(size);
        boolean expected = true;

        boolean actual = field.getFigure(p).isEmpty();

        assertThat(actual, is(expected));
    }

    @Test
    public void getFigureWhenFieldSize10By10AndFigureOInX9Y9() {
        iPoint p = new Point(9, 9);
        int size = 10;
        iFigure<?> figure = new FigureO();
        Field field = new SquareField(size);
        field.setFigure(figure, p);
        iFigure<?> expected = figure;

        iFigure<?> actual = field.getFigure(p).get();

        assertThat(actual, is(expected));
    }
}