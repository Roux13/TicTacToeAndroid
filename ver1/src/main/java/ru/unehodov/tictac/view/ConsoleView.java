package ru.unehodov.tictac.view;

import ru.unehodov.tictac.model.IField;
import ru.unehodov.tictac.model.IPlayer;

public class ConsoleView implements IntConsoleView {

    private ConsoleImageBuilder imageBuilder;

    public ConsoleView(ConsoleImageBuilder imageBuilder) {
        this.imageBuilder = imageBuilder;
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void display(IField field) {
        this.refresh();
        this.print(imageBuilder.buildImage(field));
    }

    @Override
    public void refresh() {
        int screenSize = 10;
        for (int i = 0; i < screenSize; i++) {
            this.print(System.lineSeparator());
        }
    }

    @Override
    public void showWinner(IPlayer player) {
        this.print(
                String.format("Winner is the %s, his figure %s. %nCongratulations!!!",
                        player.getName(), player.getFigure().getImage()));
    }
}
