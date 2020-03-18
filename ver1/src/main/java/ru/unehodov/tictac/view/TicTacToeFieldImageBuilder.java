package ru.unehodov.tictac.view;

import ru.unehodov.tictac.model.IField;
import ru.unehodov.tictac.model.IFigure;
import ru.unehodov.tictac.model.Point;

import java.util.Optional;

public class TicTacToeFieldImageBuilder implements ConsoleImageBuilder {
    @Override
    public String buildImage(IField field) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.buildYCoordinatesRow(field.getSize()));
        sb.append(buildLineSeparator(field.getSize()));
        for (int row = 0; row < field.getSize(); row++) {
            sb.append(buildRow(field, row));
            sb.append(buildLineSeparator(field.getSize()));
        }
        return sb.toString();
    }

    public String buildRow(IField field, int row) {
        StringBuilder sb = new StringBuilder();
        sb.append(row).append("-|");
        for (int ceil = 0; ceil < field.getSize(); ceil++) {
            Optional<IFigure<?>> figure = field.getFigure(new Point(row, ceil));
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
