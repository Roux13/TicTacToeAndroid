package ru.unehodov.model;

public class Player implements IntPlayer {

    private String name;
    private IntFigure<String> figure;

    public Player(String name, IntFigure<String> figure) {
        this.name = name;
        this.figure = figure;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IntFigure<?> getFigure() {
        return figure;
    }
}
