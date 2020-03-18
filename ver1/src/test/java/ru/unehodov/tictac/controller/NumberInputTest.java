package ru.unehodov.tictac.controller;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.StringReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NumberInputTest {

    @Test
    public void applyWhenInputIsNumber() {
        String inputString = "0";
        StringReader stringReader = new StringReader(inputString);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        Input<String> input = new TextInput(bufferedReader);
        Input<Integer> numberInput = new NumberInput(input);
        Integer expected = 0;

        Integer actual = numberInput.apply();

        assertThat(actual, is(expected));
    }

    @Test
    public void applyWhenFirstInputIsTextNextIsNumber() {
        String inputString = "Java" + System.lineSeparator() + "0";
        StringReader stringReader = new StringReader(inputString);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        Input<String> input = new TextInput(bufferedReader);
        Input<Integer> numberInput = new NumberInput(input);
        Integer expected = 0;

        Integer actual = numberInput.apply();

        assertThat(actual, is(expected));
    }

    @Test
    public void applyWhenFirstTwoInputsIsTextNextIsNumber() {
        String inputString = "Java" + System.lineSeparator() + "Java" + System.lineSeparator() + "0";
        StringReader stringReader = new StringReader(inputString);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        Input<String> input = new TextInput(bufferedReader);
        Input<Integer> numberInput = new NumberInput(input);
        Integer expected = 0;

        Integer actual = numberInput.apply();

        assertThat(actual, is(expected));
    }

}