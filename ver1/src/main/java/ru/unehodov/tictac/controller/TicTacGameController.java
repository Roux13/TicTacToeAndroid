package ru.unehodov.tictac.controller;

import ru.unehodov.tictac.model.*;
import ru.unehodov.tictac.view.IntConsoleView;

import java.util.List;

public class TicTacGameController implements GameController {

    private final IntConsoleView view;
    private final Input<String> textInput;
    private final Input<Integer> numberInput;
    private final CpuPlayerLogic cpuPlayerLogic;

    private List<IPlayer> players;
    private IField field;
    private MoveController moveController;
    private WinnerController winnerController;

    private int turnPlayer = 0;

    public TicTacGameController(IntConsoleView view,
                                Input<String> textInput,
                                Input<Integer> numberInput, CpuPlayerLogic cpuPlayerLogic) {
        this.view = view;
        this.textInput = textInput;
        this.numberInput = numberInput;
        this.cpuPlayerLogic = cpuPlayerLogic;
    }

    @Override
    public void init() {
        view.print("Please, enter the field size: ");
        int fieldSize = numberInput.apply();
        field = new SquareField(new IFigure[fieldSize][fieldSize]);
        moveController = new TicTacMoveController(field);
        IPlayer player1 = this.initPlayer(new FigureX());
        IPlayer player2 = this.initPlayer(new FigureO());
        players = List.of(player1, player2);
        winnerController = new TicTacWinnerController(field, players);
        this.run();
    }

    public IPlayer initPlayer(IFigure<String> figure) {
        view.print("Please, select player is 1 - Human or 2 - CPU: ");
        int choose = numberInput.apply();
        boolean isCpu = choose == 2;
        String name;
        if (isCpu) {
            name = "CPU";
        } else {
            view.print("Enter player name: ");
            name = textInput.apply();
        }
        return new Player(name, figure, isCpu);
    }

    @Override
    public void run() {
        while (moveController.hasEmptyCell()) {
            view.display(field);
            IPlayer currentPlayer = nextPlayer();
            IPoint currentPoint = askPoint(currentPlayer);
            field.setFigure(currentPlayer.getFigure(), currentPoint);
            if (winnerController.getWinner().isPresent()) {
                view.display(field);
                view.showWinner(currentPlayer);
                break;
            }
        }
        if (winnerController.getWinner().isEmpty()) {
            view.print(String.format("Sorry, the field is full. No winner...%nGame Over."));
        }
    }

    public IPoint askPoint(IPlayer player) {
        IPoint result = new Point(-1, -1);
        while (!moveController.validateCoordinates(result)) {
            if (player.isCpu()) {
                result = cpuPlayerLogic.getCpuPoint(field);
            } else {
                view.print("Please, enter the x coordinate: ");
                int x = numberInput.apply();
                view.print("Please, enter the y coordinate: ");
                int y = numberInput.apply();
                result = new Point(y, x);
            }
        }
        return result;
    }

    @Override
    public IPlayer nextPlayer() {
        if (turnPlayer >= players.size()) {
            turnPlayer = 0;
        }
        return players.get(turnPlayer++);
    }
}
