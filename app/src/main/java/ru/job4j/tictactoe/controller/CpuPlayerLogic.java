package ru.job4j.tictactoe.controller;

import ru.job4j.tictactoe.model.IField;
import ru.job4j.tictactoe.model.IPoint;

public interface CpuPlayerLogic {

    IPoint getCpuPoint(IField field);

}
