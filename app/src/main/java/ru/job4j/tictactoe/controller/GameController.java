package ru.job4j.tictactoe.controller;

import ru.job4j.tictactoe.model.IPlayer;

public interface GameController {

    void init();

    void run();

    IPlayer nextPlayer();
}
