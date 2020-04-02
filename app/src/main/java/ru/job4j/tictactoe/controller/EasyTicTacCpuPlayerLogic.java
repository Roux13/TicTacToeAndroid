package ru.job4j.tictactoe.controller;

import ru.job4j.tictactoe.model.IField;
import ru.job4j.tictactoe.model.IPoint;
import ru.job4j.tictactoe.model.Point;

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
