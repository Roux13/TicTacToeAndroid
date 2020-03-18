package ru.unehodov.tictac.controller;

import ru.unehodov.tictac.model.IFigure;

import java.util.Optional;

public interface WinnerController {

    Optional<IFigure<?>> getWinner();

}
