package ru.unehodov.model;

public class Player implements iPlayer {

    private String name;
    private iFigure<String> figure;

    public Player(String name, iFigure<String> figure) {
        this.name = name;
        this.figure = figure;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public iFigure<?> getFigure() {
        return figure;
    }
}
