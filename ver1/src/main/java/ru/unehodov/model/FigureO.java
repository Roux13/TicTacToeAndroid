package ru.unehodov.model;

public class FigureO implements iFigure<String> {

    private final String image = "O";

    @Override
    public String getImage() {
        return this.image;
    }
}
