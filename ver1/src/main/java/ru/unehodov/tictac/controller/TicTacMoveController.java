package ru.unehodov.tictac.controller;

import ru.unehodov.tictac.model.IField;
import ru.unehodov.tictac.model.IPoint;

import java.util.Arrays;
import java.util.Objects;

public class TicTacMoveController implements MoveController {

    private final IField field;

    public TicTacMoveController(IField field) {
        this.field = field;
    }

    @Override
    public boolean hasEmptyCell() {
        long count = Arrays.stream(field.getCells())
                .flatMap(Arrays::stream)
                .filter(Objects::isNull)
                .count();
        return count > 0;
    }

    @Override
    public boolean validateCoordinates(IPoint point) {
        return  validateSingleCoordinate(point.getX())
                && validateSingleCoordinate(point.getY())
                && field.getFigure(point).isEmpty();
    }

    public boolean validateSingleCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < field.getCells().length;
    }
}
