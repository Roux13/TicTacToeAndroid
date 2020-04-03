package ru.nehodov.tictactoe.controller;

import ru.nehodov.tictactoe.model.IFigure;

public interface WinnerController {

    IFigure<?> getWinner();

}
