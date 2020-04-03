package ru.nehodov.tictactoe.controller;

import ru.nehodov.tictactoe.model.IPlayer;

public interface GameController {

    void init();

    void run();

    IPlayer nextPlayer();
}
