package ru.unehodov.tictac.controller;

import ru.unehodov.tictac.model.IPoint;

public interface MoveController {

    boolean hasEmptyCell();

    boolean validateCoordinates(IPoint point);

}
