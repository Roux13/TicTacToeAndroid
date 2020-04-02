package ru.job4j.tictactoe.controller;

import ru.job4j.tictactoe.model.IField;
import ru.job4j.tictactoe.model.IFigure;
import ru.job4j.tictactoe.model.IPlayer;
import ru.job4j.tictactoe.model.Point;

import java.util.List;

public class TicTacWinnerController implements WinnerController {

    private final IField field;
    private final List<IPlayer> players;

    public TicTacWinnerController(IField field, List<IPlayer> players) {
        this.field = field;
        this.players = players;
    }

    @Override
    public IFigure<?> getWinner() {
        IFigure<?> result = null;
        for (IPlayer player : players) {
            IFigure<?> figure = player.getFigure();
            if (this.checkWinner(figure)) {
                result = figure;
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
            IFigure<?> cellFigure = field.getFigure(new Point(startX, startY));
            startX += deltaX;
            startY += deltaY;
            if (cellFigure == null || !cellFigure.equals(figure)) {
                result = false;
                break;
            }
        }
        return result;
    }


}
