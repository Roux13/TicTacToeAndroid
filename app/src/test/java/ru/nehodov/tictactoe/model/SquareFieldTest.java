package ru.job4j.tictactoe.model;

import org.junit.Test;

import java.lang.reflect.Field;

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
    public void setFigureWhenFieldSize3By3AndFigureXInX1Y2() {
        IPoint p = new Point(1, 2);
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

    @Test
    public void clearFieldWhenField3by3() {
        int size = 3;
        IFigure<String>[][] cells = new IFigure[size][size];
        IFigure<String>[][] emptyCells = new IFigure[size][size];
        IField field = new SquareField(cells);
        IFigure<String> figureX = new FigureX();
        field.setFigure(figureX, new Point(1, 0));
        field.setFigure(figureX, new Point(1, 1));
        field.setFigure(figureX, new Point(1, 2));
        IField expected = new SquareField(emptyCells);

        field.clearField();

        assertArrayEquals(expected.getCells(), field.getCells());
    }
}