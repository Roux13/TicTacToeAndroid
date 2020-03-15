package ru.unehodov.view;

import ru.unehodov.model.Field;

public class ConsoleView implements iConsoleView {

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


}
