package ru.unehodov.tictac;

import ru.unehodov.tictac.controller.*;
import ru.unehodov.tictac.view.ConsoleView;
import ru.unehodov.tictac.view.IntConsoleView;
import ru.unehodov.tictac.view.TicTacToeFieldImageBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TicTacToeGame {

    public static void main(String... args) {
        IntConsoleView consoleView = new ConsoleView(new TicTacToeFieldImageBuilder());
        Input<String> textInput = new TextInput(new BufferedReader(new InputStreamReader(System.in)));
        Input<Integer> numberInput = new NumberInput(textInput);
        CpuPlayerLogic cpuPlayerLogic = new EasyTicTacCpuPlayerLogic();
        TicTacGameController gameController = new TicTacGameController(consoleView, textInput, numberInput, cpuPlayerLogic);
        gameController.init();
    }

}
