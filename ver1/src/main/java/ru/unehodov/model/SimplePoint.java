package ru.unehodov.model;

public class SimplePoint implements Point {

    private final int x;
    private final int y;

    public SimplePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

}
