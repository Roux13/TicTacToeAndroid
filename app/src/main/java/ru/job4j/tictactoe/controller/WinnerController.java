package ru.job4j.tictactoe.controller;

import ru.job4j.tictactoe.model.IFigure;

public interface WinnerController {

    IFigure<?> getWinner();

}
