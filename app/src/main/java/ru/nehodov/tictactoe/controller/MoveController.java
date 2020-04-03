package ru.nehodov.tictactoe.controller;

import ru.nehodov.tictactoe.model.IPoint;

public interface MoveController {

    boolean hasEmptyCell();

    boolean validateCoordinates(IPoint point);

}
