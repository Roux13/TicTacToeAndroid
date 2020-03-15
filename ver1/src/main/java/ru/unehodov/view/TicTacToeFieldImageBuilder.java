package ru.unehodov.view;

import ru.unehodov.model.Field;
import ru.unehodov.model.iFigure;
import ru.unehodov.model.Point;

import java.util.Optional;

public class TicTacToeFieldImageBuilder implements ConsoleImageBuilder {
    @Override
    public String buildImage(Field field) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.buildYCoordinatesRow(field.getSize()));
        sb.append(buildLineSeparator(field.getSize()));
        for (int row = 0; row < field.getSize(); row++) {
            sb.append(buildRow(field, row));
            sb.append(buildLineSeparator(field.getSize()));
        }
        return sb.toString();
    }

    public String buildRow(Field field, int row) {
        StringBuilder sb = new StringBuilder();
        sb.append(row).append("-|");
        for (int ceil = 0; ceil < field.getSize(); ceil++) {
            Optional<iFigure<?>> figure = field.getFigure(new Point(row, ceil));
            if (figure.isPresent()) {
                sb.append(figure.get().getImage());
            } else {
                sb.append(" ");
            }
            sb.append("|");
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public String buildYCoordinatesRow(int fieldWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        for (int i = 0; i < fieldWidth; i++) {
            sb.append(i).append(" ");
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    public String buildLineSeparator(int fieldWidth) {
        StringBuilder sb = new StringBuilder();
        sb.append("---");
        for (int i = 0; i < fieldWidth; i++) {
            sb.append("--");
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }

}
