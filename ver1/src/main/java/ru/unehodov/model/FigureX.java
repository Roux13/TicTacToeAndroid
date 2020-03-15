package ru.unehodov.model;

public class FigureX implements IntFigure<String> {

    private final String image = "X";

    @Override
    public String getImage() {
        return this.image;
    }
}
