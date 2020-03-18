package ru.unehodov.tictac.controller;

import org.junit.Test;
import ru.unehodov.tictac.model.IField;
import ru.unehodov.tictac.model.IFigure;
import ru.unehodov.tictac.model.IPoint;
import ru.unehodov.tictac.model.SquareField;

import static org.junit.Assert.*;

public class EasyTicTacCpuPlayerLogicTest {

    @Test
    public void getPointWhenField1By1() {
        int size = 1;
        IFigure<String>[][] figures = new IFigure[size][size];
        IField field = new SquareField(figures);

        IPoint actual = new EasyTicTacCpuPlayerLogic().getCpuPoint(field);

        assertTrue(actual.getX() >= 0);
        assertTrue(actual.getX() < field.getSize());
        assertTrue(actual.getY() >= 0);
        assertTrue(actual.getY() < field.getSize());
    }

}