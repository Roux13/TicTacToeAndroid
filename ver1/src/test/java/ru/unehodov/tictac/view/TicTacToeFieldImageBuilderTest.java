package ru.unehodov.tictac.view;

import org.junit.Test;
import ru.unehodov.tictac.model.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TicTacToeFieldImageBuilderTest {

    @Test
    public void buildYCoordinatesROwWhen3() {
        int width = 3;
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        String expected = "   0 1 2 " + System.lineSeparator();

        String actual = imageBuilder.buildYCoordinatesRow(width);

        assertThat(actual, is(expected));
    }

    @Test
    public void buildYCoordinatesRowWhen5() {
        int width = 5;
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        String expected = "   0 1 2 3 4 " + System.lineSeparator();

        String actual = imageBuilder.buildYCoordinatesRow(width);

        assertThat(actual, is(expected));
    }

    @Test
    public void buildRowSeparatorWhen3() {
        int width = 3;
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        String expected = "---------" + System.lineSeparator();

        String actual = imageBuilder.buildLineSeparator(width);

        assertThat(actual, is(expected));
    }

    @Test
    public void buildLineSeparatorWhen5() {
        int width = 5;
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        String expected = "-------------" + System.lineSeparator();

        String actual = imageBuilder.buildLineSeparator(width);

        assertThat(actual, is(expected));
    }

    @Test
    public void buildRowWhenField1by1AndRow0() {
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        int size = 1;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        String expected = "0-| |" + System.lineSeparator();

        String actual = imageBuilder.buildRow(field, 0);

        assertThat(actual, is(expected));
    }

    @Test
    public void buildRowWhenField3by3AndRow0() {
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        int size = 3;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        String expected = "0-| | | |" + System.lineSeparator();

        String actual = imageBuilder.buildRow(field, 0);

        assertThat(actual, is(expected));
    }

    @Test
    public void buildRowWhenField3by3AndRow2() {
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        int size = 3;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        String expected = "2-| | | |" + System.lineSeparator();

        String actual = imageBuilder.buildRow(field, 2);

        assertThat(actual, is(expected));
    }

    @Test
    public void displayWhenField1by1AndEmptyField() {
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        int size = 1;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        String expected = "   0 " + System.lineSeparator()
                        + "-----" + System.lineSeparator()
                        + "0-| |" + System.lineSeparator()
                        + "-----" + System.lineSeparator();

        String actual = imageBuilder.buildImage(field);

        assertThat(actual, is(expected));
    }

    @Test
    public void displayWhenField3by3AndEmptyField() {
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        int size = 3;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        String expected = "   0 1 2 " + System.lineSeparator()
                        + "---------" + System.lineSeparator()
                        + "0-| | | |" + System.lineSeparator()
                        + "---------" + System.lineSeparator()
                        + "1-| | | |" + System.lineSeparator()
                        + "---------" + System.lineSeparator()
                        + "2-| | | |" + System.lineSeparator()
                        + "---------" + System.lineSeparator();

        String actual = imageBuilder.buildImage(field);

        assertThat(actual, is(expected));
    }

    @Test
    public void displayWhenField3by3AndFigureXAtPoint00() {
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        int size = 3;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        field.setFigure(new FigureX(), new Point(0, 0));
        String expected = "   0 1 2 " + System.lineSeparator()
                + "---------" + System.lineSeparator()
                + "0-|X| | |" + System.lineSeparator()
                + "---------" + System.lineSeparator()
                + "1-| | | |" + System.lineSeparator()
                + "---------" + System.lineSeparator()
                + "2-| | | |" + System.lineSeparator()
                + "---------" + System.lineSeparator();

        String actual = imageBuilder.buildImage(field);

        assertThat(actual, is(expected));
    }

    @Test
    public void displayWhenField3by3AndFigureOAtPoint22() {
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        int size = 3;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        field.setFigure(new FigureO(), new Point(2, 2));
        String expected = "   0 1 2 " + System.lineSeparator()
                + "---------" + System.lineSeparator()
                + "0-| | | |" + System.lineSeparator()
                + "---------" + System.lineSeparator()
                + "1-| | | |" + System.lineSeparator()
                + "---------" + System.lineSeparator()
                + "2-| | |O|" + System.lineSeparator()
                + "---------" + System.lineSeparator();

        String actual = imageBuilder.buildImage(field);

        assertThat(actual, is(expected));
    }

    @Test
    public void displayWhenField3by3AndFigureXAtPoint02And11And20() {
        TicTacToeFieldImageBuilder imageBuilder = new TicTacToeFieldImageBuilder();
        int size = 3;
        IFigure<String>[][] cells = new IFigure[size][size];
        IField field = new SquareField(cells);
        field.setFigure(new FigureX(), new Point(0, 2));
        field.setFigure(new FigureX(), new Point(1, 1));
        field.setFigure(new FigureX(), new Point(2, 0));
        String expected = "   0 1 2 " + System.lineSeparator()
                + "---------" + System.lineSeparator()
                + "0-| | |X|" + System.lineSeparator()
                + "---------" + System.lineSeparator()
                + "1-| |X| |" + System.lineSeparator()
                + "---------" + System.lineSeparator()
                + "2-|X| | |" + System.lineSeparator()
                + "---------" + System.lineSeparator();

        String actual = imageBuilder.buildImage(field);

        assertThat(actual, is(expected));
    }
}