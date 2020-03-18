package ru.unehodov.tictac.model;

public class Player implements IPlayer {

    private final String name;
    private final IFigure<String> figure;
    private final boolean isCpu;

    public Player(String name, IFigure<String> figure, boolean isCpu) {
        this.name = name;
        this.figure = figure;
        this.isCpu = isCpu;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public IFigure<?> getFigure() {
        return this.figure;
    }

    @Override
    public boolean isCpu() {
        return this.isCpu;
    }
}
