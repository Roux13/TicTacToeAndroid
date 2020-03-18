package ru.unehodov.tictac.controller;

import ru.unehodov.tictac.model.IField;
import ru.unehodov.tictac.model.IFigure;
import ru.unehodov.tictac.model.IPlayer;
import ru.unehodov.tictac.model.Point;

import java.util.List;
import java.util.Optional;

public class TicTacWinnerController implements WinnerController {

    private final IField field;
    private final List<IPlayer> players;

    public TicTacWinnerController(IField field, List<IPlayer> players) {
        this.field = field;
        this.players = players;
    }

    @Override
    public Optional<IFigure<?>> getWinner() {
        Optional<IFigure<?>> result = Optional.empty();
        for (IPlayer player : players) {
            IFigure<?> figure = player.getFigure();
            if (this.checkWinner(figure)) {
                result = Optional.of(figure);
            }
        }
        return result;
    }

    public boolean checkWinner(IFigure<?> figure) {
        boolean result = false;
        if (this.scanField(figure, 0, 0, 1, 1)
                || this.scanField(figure, 0, field.getSize() - 1, 1, -1)) {
            return true;
        }
        for (int index = 0; index < field.getSize(); index++) {
            if (this.scanField(figure, index, 0, 0, 1)
                    || this.scanField(figure, 0, index, 1, 0)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean scanField(IFigure<?> figure, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index < field.getSize(); index++) {
            Optional<IFigure<?>> cellFigure = field.getFigure(new Point(startX, startY));
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
