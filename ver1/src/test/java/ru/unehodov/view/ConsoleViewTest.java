package ru.unehodov.view;

import org.junit.Test;
import ru.unehodov.model.Field;
import ru.unehodov.model.SquareField;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConsoleViewTest {


    @Test
    public void displayWhenField1by1AndFigureX() {
        Field field = new SquareField(1);
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
        Field field = new SquareField(3);
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
        Field field = new SquareField(5);
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
}