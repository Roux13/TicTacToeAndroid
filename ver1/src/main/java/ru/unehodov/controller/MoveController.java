package ru.unehodov.controller;

import ru.unehodov.model.IntPoint;

public interface MoveController {

    boolean hasEmptyCell();

    boolean validateCoordinates(IntPoint point);

}
