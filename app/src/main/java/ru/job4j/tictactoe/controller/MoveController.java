package ru.job4j.tictactoe.controller;

import ru.job4j.tictactoe.model.IPoint;

public interface MoveController {

    boolean hasEmptyCell();

    boolean validateCoordinates(IPoint point);

}
