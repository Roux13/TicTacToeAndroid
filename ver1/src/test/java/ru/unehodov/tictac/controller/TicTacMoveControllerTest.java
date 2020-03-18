package ru.unehodov.tictac.controller;

import org.junit.Test;
import ru.unehodov.tictac.model.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TicTacMoveControllerTest {

    @Test
    public void hasEmptyCellWhenField1by1AndEmptyThenTrue() {
        int size = 1;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        boolean expected = true;

        boolean actual = new TicTacMoveController(field).hasEmptyCell();

        assertThat(actual, is(expected));
    }

    @Test
    public void hasEmptyCellWhenField1by1AndFullThenFalse() {
        int size = 1;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        field.setFigure(new FigureX(), new Point(0, 0));
        boolean expected = false;

        boolean actual = new TicTacMoveController(field).hasEmptyCell();

        assertThat(actual, is(expected));
    }

    @Test
    public void hasEmptyCellWhenField3by3AndHasEmptyCellThenTrue() {
        int size = 3;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        field.setFigure(new FigureX(), new Point(0, 0));
        field.setFigure(new FigureX(), new Point(0, 1));
        field.setFigure(new FigureX(), new Point(0, 2));
        field.setFigure(new FigureX(), new Point(1, 0));
        field.setFigure(new FigureX(), new Point(1, 1));
        field.setFigure(new FigureX(), new Point(1, 2));
        field.setFigure(new FigureX(), new Point(2, 0));
        field.setFigure(new FigureX(), new Point(2, 1));
        boolean expected = true;

        boolean actual = new TicTacMoveController(field).hasEmptyCell();

        assertThat(actual, is(expected));
    }

    @Test
    public void hasEmptyCellWhenField3by3AndNoEmptyCellThenFalse() {
        int size = 3;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        field.setFigure(new FigureX(), new Point(0, 0));
        field.setFigure(new FigureX(), new Point(0, 1));
        field.setFigure(new FigureX(), new Point(0, 2));
        field.setFigure(new FigureX(), new Point(1, 0));
        field.setFigure(new FigureX(), new Point(1, 1));
        field.setFigure(new FigureX(), new Point(1, 2));
        field.setFigure(new FigureX(), new Point(2, 0));
        field.setFigure(new FigureX(), new Point(2, 1));
        field.setFigure(new FigureX(), new Point(2, 2));
        boolean expected = false;

        boolean actual = new TicTacMoveController(field).hasEmptyCell();

        assertThat(actual, is(expected));
    }

    @Test
    public void validateCoordinatesWhenField1By1AndPoint00ThenTrue() {
        int size = 1;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        Point p = new Point(0, 0);
        boolean expected = true;

        boolean actual = new TicTacMoveController(field).validateCoordinates(p);

        assertThat(actual, is(expected));
    }

    @Test
    public void validateCoordinatesWhenField1By1AndPoint01ThenFalse() {
        int size = 1;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        Point p = new Point(0, 1);
        boolean expected = false;

        boolean actual = new TicTacMoveController(field).validateCoordinates(p);

        assertThat(actual, is(expected));
    }

    @Test
    public void validateCoordinatesWhenField1By1AndPoint0Minus1ThenFalse() {
        int size = 1;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        Point p = new Point(0, -1);
        boolean expected = false;

        boolean actual = new TicTacMoveController(field).validateCoordinates(p);

        assertThat(actual, is(expected));
    }

    @Test
    public void validateCoordinatesWhenField1By1AndPoint10ThenFalse() {
        int size = 1;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        Point p = new Point(1, 0);
        boolean expected = false;

        boolean actual = new TicTacMoveController(field).validateCoordinates(p);

        assertThat(actual, is(expected));
    }

    @Test
    public void validateCoordinatesWhenField1By1AndPointMinus10ThenFalse() {
        int size = 1;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        Point p = new Point(-1, 0);
        boolean expected = false;

        boolean actual = new TicTacMoveController(field).validateCoordinates(p);

        assertThat(actual, is(expected));
    }

    @Test
    public void validateCoordinatesWhenField1By1HasFigureInCell00AndPoint00ThenFalse() {
        int size = 1;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        Point p = new Point(0, 0);
        field.setFigure(new FigureX(), p);
        boolean expected = false;

        boolean actual = new TicTacMoveController(field).validateCoordinates(p);

        assertThat(actual, is(expected));
    }

}