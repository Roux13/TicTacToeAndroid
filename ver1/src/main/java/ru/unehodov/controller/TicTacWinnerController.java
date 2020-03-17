package ru.unehodov.controller;

import ru.unehodov.model.Field;
import ru.unehodov.model.IntFigure;
import ru.unehodov.model.IntPlayer;
import ru.unehodov.model.Point;

import java.util.List;
import java.util.Optional;

public class TicTacWinnerController implements WinnerController {

    private final Field field;
    private final List<IntPlayer> players;

    public TicTacWinnerController(Field field, List<IntPlayer> players) {
        this.field = field;
        this.players = players;
    }

    @Override
    public Optional<IntFigure<?>> getWinner() {
        Optional<IntFigure<?>> result = Optional.empty();
        for (IntPlayer player : players) {
            IntFigure<?> figure = player.getFigure();
            if (this.checkWinner(figure)) {
                result = Optional.of(figure);
            }
        }
        return result;
    }

    public boolean checkWinner(IntFigure<?> figure) {
        boolean result = false;
        if (this.scanField(figure, 0, 0, 1, 1)
                || this.scanField(figure, 0, field.getSize() - 1, 1, -1)) {
            return true;
        }
        for (int index = 0; index < field.getSize(); index++) {
            if (this.scanField(figure, index, 0, 0, 1)
                    || this.scanField(figure, 0, index, 0, 1)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean scanField(IntFigure<?> figure, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index < field.getSize(); index++) {
            Optional<IntFigure<?>> cellFigure = field.getFigure(new Point(startX, startY));
            startX += deltaX;
            startY += deltaY;
            if (cellFigure.isEmpty() || !cellFigure.get().equals(figure)) {
                result = false;
                break;
            }
        }
        return result;
    }


}
