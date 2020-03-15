package ru.unehodov.model;

public class FigureO implements IntFigure<String> {

    private final String image = "O";

    @Override
    public String getImage() {
        return this.image;
    }
}
