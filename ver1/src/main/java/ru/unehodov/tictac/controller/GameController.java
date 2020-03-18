package ru.unehodov.tictac.controller;

import ru.unehodov.tictac.model.IPlayer;

public interface GameController {

    void init();

    void run();

    IPlayer nextPlayer();
}
