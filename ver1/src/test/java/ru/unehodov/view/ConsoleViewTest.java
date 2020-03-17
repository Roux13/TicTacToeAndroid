package ru.unehodov.view;

import org.junit.Test;
import ru.unehodov.model.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConsoleViewTest {


    @Test
    public void displayWhenField1by1AndFigureX() {
        int size = 1;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntConsoleView view = new ConsoleView(new TicTacToeFieldImageBuilder());
        String expected = "   0 " + System.lineSeparator()
                        + "-----" + System.lineSeparator()
                        + "0-| |" + System.lineSeparator()
                        + "-----" + System.lineSeparator();
        PrintStream stdOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        view.display(field);
        String actual = baos.toString();

        assertThat(actual, is(expected));
        System.setOut(stdOut);
    }
//
    @Test
    public void displayWhenField3by3() {
        int size = 3;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        IntConsoleView view = new ConsoleView(new TicTacToeFieldImageBuilder());
        String expected = "   0 1 2 " + System.lineSeparator()
                        + "---------" + System.lineSeparator()
                        + "0-| | | |" + System.lineSeparator()
                        + "---------" + System.lineSeparator()
                        + "1-| | | |" + System.lineSeparator()
                        + "---------" + System.lineSeparator()
                        + "2-| | | |" + System.lineSeparator()
                        + "---------" + System.lineSeparator();

        PrintStream stdOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        view.display(field);
        String actual = baos.toString();

        assertThat(actual, is(expected));
        System.setOut(stdOut);
    }

    @Test
    public void displayWhenField5by5() {
        int size = 5;
        IntFigure<String>[][] cells = new IntFigure[size][size];
        Field field = new SquareField(cells);
        View view = new ConsoleView(new TicTacToeFieldImageBuilder());
        String expected = "   0 1 2 3 4 " + System.lineSeparator()
                        + "-------------" + System.lineSeparator()
                        + "0-| | | | | |" + System.lineSeparator()
                        + "-------------" + System.lineSeparator()
                        + "1-| | | | | |" + System.lineSeparator()
                        + "-------------" + System.lineSeparator()
                        + "2-| | | | | |" + System.lineSeparator()
                        + "-------------" + System.lineSeparator()
                        + "3-| | | | | |" + System.lineSeparator()
                        + "-------------" + System.lineSeparator()
                        + "4-| | | | | |" + System.lineSeparator()
                        + "-------------" + System.lineSeparator();

        PrintStream stdOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        view.display(field);
        String actual = baos.toString();

        assertThat(actual, is(expected));
        System.setOut(stdOut);
    }

    @Test
    public void showWinner() {
        IntPlayer player = new Player("Name", new FigureX());
        View view = new ConsoleView(new TicTacToeFieldImageBuilder());
        PrintStream stdOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        view.showWinner(player);
        String expected = "Winner is the Name, his figure X. " + System.lineSeparator() +  "Congratulations!!!";

        String actual = baos.toString();

        assertThat(actual, is(expected));
        System.setOut(stdOut);
    }
}