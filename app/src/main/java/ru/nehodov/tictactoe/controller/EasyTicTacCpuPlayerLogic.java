package ru.nehodov.tictactoe.controller;

import ru.nehodov.tictactoe.model.IField;
import ru.nehodov.tictactoe.model.IPoint;
import ru.nehodov.tictactoe.model.Point;

import java.util.Random;

public class EasyTicTacCpuPlayerLogic implements CpuPlayerLogic {

    @Override
    public IPoint getCpuPoint(IField field) {
        Random random = new Random();
        int x = random.nextInt(field.getSize());
        int y = random.nextInt(field.getSize());
        return new Point(x, y);
    }
}
