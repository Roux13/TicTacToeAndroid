package ru.nehodov.tictactoe.controller;

import ru.nehodov.tictactoe.model.IField;
import ru.nehodov.tictactoe.model.IPoint;

public interface CpuPlayerLogic {

    IPoint getCpuPoint(IField field);

}
