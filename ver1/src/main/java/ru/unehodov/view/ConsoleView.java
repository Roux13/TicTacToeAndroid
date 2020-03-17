package ru.unehodov.view;

import ru.unehodov.model.Field;
import ru.unehodov.model.IntPlayer;

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
    public void display(Field field) {
        this.print(imageBuilder.buildImage(field));
    }

    @Override
    public void refresh() {
        int screenSize = 10;
        for (int i = 0; i < screenSize; i++) {
            this.print("");
        }
    }

    @Override
    public void showWinner(IntPlayer player) {
        this.print(
                String.format("Winner is the %s, his figure %s. %nCongratulations!!!",
                        player.getName(), player.getFigure().getImage()));
    }
}
