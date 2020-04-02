package ru.job4j.tictactoe.controller;

import org.junit.Test;

import ru.job4j.tictactoe.model.IField;
import ru.job4j.tictactoe.model.IFigure;
import ru.job4j.tictactoe.model.IPoint;
import ru.job4j.tictactoe.model.SquareField;

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