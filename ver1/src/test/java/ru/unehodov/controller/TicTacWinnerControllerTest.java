package ru.unehodov.controller;

import org.junit.Test;
import ru.unehodov.model.*;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TicTacWinnerControllerTest {


    @Test
    public void getWinnerWhenField1By1AndIsEmpty() {
        int size = 1;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        List<IntPlayer> players = List.of(new Player("player", new FigureX()));
        WinnerController winnerController = new TicTacWinnerController(field, players);
        boolean expected = true;

        boolean actual = winnerController.getWinner().isEmpty();

        assertThat(actual, is(expected));
    }

    @Test
    public void getWinnerWhenField1By1AndWinnerX() {
        int size = 1;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        IntFigure<String> winner = new FigureX();
        Field field = new SquareField(cells);
        field.setFigure(winner, new Point(0, 0));
        List<IntPlayer> players = List.of(new Player("player", new FigureX()));
        IntFigure<String> expected = winner;

        IntFigure<?> actual = new TicTacWinnerController(field, players).getWinner().get();

        assertThat(actual, is(expected));
    }

    @Test
    public void getWinnerWhenField3By3AndNoWinner() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        IntFigure<String> winner = new FigureX();
        Field field = new SquareField(cells);
        field.setFigure(winner, new Point(0, 0));
        List<IntPlayer> players = List.of(new Player("player", new FigureX()));
        boolean expected = true;

        boolean actual = new TicTacWinnerController(field, players).getWinner().isEmpty();

        assertThat(actual, is(expected));
    }

    @Test
    public void getWinnerWhenField3By3AndWinnerX() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        IntFigure<String> winner = new FigureX();
        Field field = new SquareField(cells);
        field.setFigure(winner, new Point(0, 0));
        field.setFigure(winner, new Point(0, 1));
        field.setFigure(winner, new Point(0, 2));
        List<IntPlayer> players = List.of(new Player("player", new FigureX()));
        IntFigure<?> expected = winner;

        IntFigure<?> actual = new TicTacWinnerController(field, players).getWinner().get();

        assertThat(actual, is(expected));
    }

    @Test
    public void getWinnerWhenField3By3AndWinnerO() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        IntFigure<String> winner = new FigureO();
        IntFigure<String> looser = new FigureX();
        Field field = new SquareField(cells);
        field.setFigure(winner, new Point(0, 0));
        field.setFigure(winner, new Point(1, 1));
        field.setFigure(winner, new Point(2, 2));
        field.setFigure(looser, new Point(1, 2));
        field.setFigure(looser, new Point(0, 1));
        field.setFigure(looser, new Point(2, 1));
        List<IntPlayer> players = List.of(new Player("player1", winner), new Player("player2", looser));
        IntFigure<?> expected = winner;

        IntFigure<?> actual = new TicTacWinnerController(field, players).getWinner().get();

        assertThat(actual, is(expected));
    }

    @Test
    public void scanFieldWhenFieldIsEmpty() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = false;

        boolean actual = winnerController.scanField(new FigureX(), 0, 0, 0, 1);

        assertThat(actual, is(expected));
    }

    @Test
    public void scanFieldWhenTwoFigureXInHorizontal() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureX = new FigureX();
        field.setFigure(figureX, new Point(0, 0));
        field.setFigure(figureX, new Point(0, 1));
        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = false;

        boolean actual = winnerController.scanField(figureX, 0, 0, 0, 1);

        assertThat(actual, is(expected));
    }

    @Test
    public void scanFieldWhenFirstHorizontalWinnerX() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureX = new FigureX();
        field.setFigure(figureX, new Point(0, 0));
        field.setFigure(figureX, new Point(0, 1));
        field.setFigure(figureX, new Point(0, 2));
        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = true;

        boolean actual = winnerController.scanField(figureX, 0, 0, 0, 1);

        assertThat(actual, is(expected));
    }

    @Test
    public void scanFieldWhenSecondHorizontalWinnerX() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureX = new FigureX();
        field.setFigure(figureX, new Point(1, 0));
        field.setFigure(figureX, new Point(1, 1));
        field.setFigure(figureX, new Point(1, 2));
        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = true;

        boolean actual = winnerController.scanField(figureX, 1, 0, 0, 1);

        assertThat(actual, is(expected));
    }

    @Test
    public void scanFieldWhenThirdHorizontalWinnerX() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureX = new FigureX();
        field.setFigure(figureX, new Point(2, 0));
        field.setFigure(figureX, new Point(2, 1));
        field.setFigure(figureX, new Point(2, 2));
        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = true;

        boolean actual = winnerController.scanField(figureX, 2, 0, 0, 1);

        assertThat(actual, is(expected));
    }

    @Test
    public void scanFieldWhenFirstVerticalWinnerO() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureO = new FigureO();
        field.setFigure(figureO, new Point(0, 0));
        field.setFigure(figureO, new Point(1, 0));
        field.setFigure(figureO, new Point(2, 0));
        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = true;

        boolean actual = winnerController.scanField(figureO, 0, 0, 1, 0);

        assertThat(actual, is(expected));
    }

    @Test
    public void scanFieldWhenSecondVerticalWinnerO() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureO = new FigureO();
        field.setFigure(figureO, new Point(0, 1));
        field.setFigure(figureO, new Point(1, 1));
        field.setFigure(figureO, new Point(2, 1));
        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = true;

        boolean actual = winnerController.scanField(figureO, 0, 1, 1, 0);

        assertThat(actual, is(expected));
    }

    @Test
    public void scanFieldWhenThirdVerticalWinnerO() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureO = new FigureO();
        field.setFigure(figureO, new Point(0, 2));
        field.setFigure(figureO, new Point(1, 2));
        field.setFigure(figureO, new Point(2, 2));
        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = true;

        boolean actual = winnerController.scanField(figureO, 0, 2, 1, 0);

        assertThat(actual, is(expected));
    }

    @Test
    public void scanFieldWhenMainDiagonalWinnerO() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureO = new FigureO();
        field.setFigure(figureO, new Point(0, 0));
        field.setFigure(figureO, new Point(1, 1));
        field.setFigure(figureO, new Point(2, 2));
        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = true;

        boolean actual = winnerController.scanField(figureO, 0, 0, 1, 1);

        assertThat(actual, is(expected));
    }

    @Test
    public void scanFieldWhenReverseDiagonalWinnerX() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureX = new FigureO();
        field.setFigure(figureX, new Point(0, 2));
        field.setFigure(figureX, new Point(1, 1));
        field.setFigure(figureX, new Point(2, 0));
        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = true;

        boolean actual = winnerController.scanField(figureX, 0, field.getSize() - 1, 1, -1);

        assertThat(actual, is(expected));
    }

    @Test
    public void checkWinnerWhenFieldIsEmpty() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureX = new FigureX();
        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = false;

        boolean actual = winnerController.checkWinner(figureX);

        assertThat(actual, is(expected));
    }

    @Test
    public void checkWinnerWhenFirstHorizontalX() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureX = new FigureX();
        field.setFigure(figureX, new Point(0, 0));
        field.setFigure(figureX, new Point(0, 1));
        field.setFigure(figureX, new Point(0, 2));

        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = true;

        boolean actual = winnerController.checkWinner(figureX);

        assertThat(actual, is(expected));
    }

    @Test
    public void checkWinnerWhenMainDiagonalO() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntFigure<String> figureO = new FigureO();
        field.setFigure(figureO, new Point(0, 0));
        field.setFigure(figureO, new Point(1, 1));
        field.setFigure(figureO, new Point(2, 2));

        TicTacWinnerController winnerController = new TicTacWinnerController(field, List.of());
        boolean expected = true;

        boolean actual = winnerController.checkWinner(figureO);

        assertThat(actual, is(expected));
    }
}