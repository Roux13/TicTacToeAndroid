package ru.unehodov.tictac.controller;

import ru.unehodov.tictac.model.IField;
import ru.unehodov.tictac.model.IPoint;
import ru.unehodov.tictac.model.Point;

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
