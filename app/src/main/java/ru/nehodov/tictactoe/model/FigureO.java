package ru.nehodov.tictactoe.model;

import java.util.Objects;

public class FigureO implements IFigure<String> {

    private final String image = "O";

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
        FigureO figureO = (FigureO) o;
        return Objects.equals(image, figureO.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image);
    }
}
