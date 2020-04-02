package ru.job4j.tictactoe.controller;

import java.io.BufferedReader;
import java.io.IOException;

public class TextInput implements Input<String> {

    private final BufferedReader reader;

    public TextInput(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public String apply() {
        String result = "";
        try {
            result = reader.readLine();
        } catch (IOException e) {
            System.out.println("Wrong input");
            this.apply();
        }
        return result;
    }
}
