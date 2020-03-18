package ru.unehodov.tictac.model;

import java.util.Objects;

public class FigureX implements IFigure<String> {

    private final String image = "X";

    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FigureX figureX = (FigureX) o;
        return Objects.equals(image, figureX.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image);
    }
}
