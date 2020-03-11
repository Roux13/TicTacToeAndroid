package ru.unehodov.model;

public enum Figure {

    X,
    O;

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
