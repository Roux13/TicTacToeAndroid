package ru.unehodov.controller;

import ru.unehodov.model.IntFigure;

import java.util.Optional;

public interface WinnerController {

    Optional<IntFigure<?>> getWinner();

}
