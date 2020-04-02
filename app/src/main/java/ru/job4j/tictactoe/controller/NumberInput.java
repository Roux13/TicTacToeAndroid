package ru.job4j.tictactoe.controller;

public class NumberInput implements Input<Integer> {

    private final Input<String> textInput;

    public NumberInput(Input<String> textInput) {
        this.textInput = textInput;
    }

    @Override
    public Integer apply() {
        int result = 0;
        try {
            result = Integer.parseInt(textInput.apply());
        } catch (NumberFormatException e) {
            System.out.println("Wrong input. Please, enter a number:");
            this.apply();
        }
        return result;
    }
}
