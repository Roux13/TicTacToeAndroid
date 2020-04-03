package ru.nehodov.tictactoe.controller;

import ru.nehodov.tictactoe.model.IField;
import ru.nehodov.tictactoe.model.IFigure;
import ru.nehodov.tictactoe.model.IPoint;

import java.util.Arrays;
import java.util.Objects;

public class TicTacMoveController implements MoveController {

    private final IField field;

    public TicTacMoveController(IField field) {
        this.field = field;
    }

    @Override
    public boolean hasEmptyCell() {
        long count = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            count = Arrays.stream(field.getCells())
                    .flatMap(Arrays::stream)
                    .filter(Objects::isNull)
                    .count();
        } else {
            for (IFigure<?>[] row : field.getCells()) {
                for (IFigure<?> cell : row) {
                    if (cell == null) {
                        count++;
                    }
                }
            }
        }
        return count > 0;
    }

    @Override
    public boolean validateCoordinates(IPoint point) {
        return  validateSingleCoordinate(point.getX())
                && validateSingleCoordinate(point.getY())
                && field.getFigure(point) == null;
    }

    public boolean validateSingleCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < field.getCells().length;
    }
}
