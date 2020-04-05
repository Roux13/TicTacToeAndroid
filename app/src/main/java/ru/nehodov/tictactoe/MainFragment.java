package ru.nehodov.tictactoe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ru.nehodov.tictactoe.controller.CpuPlayerLogic;
import ru.nehodov.tictactoe.controller.EasyTicTacCpuPlayerLogic;
import ru.nehodov.tictactoe.controller.MoveController;
import ru.nehodov.tictactoe.controller.TicTacMoveController;
import ru.nehodov.tictactoe.controller.TicTacWinnerController;
import ru.nehodov.tictactoe.controller.WinnerController;
import ru.nehodov.tictactoe.model.FigureO;
import ru.nehodov.tictactoe.model.FigureX;
import ru.nehodov.tictactoe.model.IField;
import ru.nehodov.tictactoe.model.IFigure;
import ru.nehodov.tictactoe.model.IPlayer;
import ru.nehodov.tictactoe.model.IPoint;
import ru.nehodov.tictactoe.model.Player;
import ru.nehodov.tictactoe.model.Point;
import ru.nehodov.tictactoe.model.SquareField;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String FIELD_KEY = "TicTacToeField";
    private static final String TURN_KEY = "TicTacToeTurnKey";

    private static final int FIELD_SIZE = 3;

    private View view;
    private Switch cpuSwitch;
    private Map<Integer, IPoint> buttonCoordinates = new LinkedHashMap<>();
    private Map<Integer, Button> buttons = new LinkedHashMap<>();
    private TextView whoseTurnTextView;

    private List<IPlayer> players;
    private IField field;
    private MoveController moveController;
    private WinnerController winnerController;
    private CpuPlayerLogic cpuPlayerLogic;

    private int whichPlayer = 0;

    public MainFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment, container, false);

        cpuSwitch = view.findViewById(R.id.switch_cpu);
        cpuSwitch.setChecked(true);
        cpuSwitch.setOnClickListener(this::onSwitchOn);
        initButtons();
        whoseTurnTextView = view.findViewById(R.id.whose_turn);
        init();
        refresh();
        if (savedInstanceState != null) {
            field = (IField) savedInstanceState.getSerializable(FIELD_KEY);
            moveController = new TicTacMoveController(field);
            winnerController = new TicTacWinnerController(field, players);
            players.get(1).setCpu(cpuSwitch.isChecked());
            whichPlayer = savedInstanceState.getInt(TURN_KEY);
            refresh();
        }
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(FIELD_KEY, (Serializable) field);
        outState.putInt(TURN_KEY, whichPlayer);
    }

    public void init() {
        int fieldSize = FIELD_SIZE;
        field = new SquareField(new IFigure[fieldSize][fieldSize]);
        moveController = new TicTacMoveController(field);
        IPlayer player1 = new Player("Player X", new FigureX(), false);
        IPlayer player2 = new Player("Player O", new FigureO(), cpuSwitch.isChecked());
        players = Arrays.asList(player1, player2);
        winnerController = new TicTacWinnerController(field, players);
        cpuPlayerLogic = new EasyTicTacCpuPlayerLogic();
        whichPlayer = 0;
        refresh();
    }

    public void initButtons() {
        buttonCoordinates.put(R.id.x0y0, new Point(0, 0));
        buttonCoordinates.put(R.id.x1y0, new Point(1, 0));
        buttonCoordinates.put(R.id.x2y0, new Point(2, 0));
        buttonCoordinates.put(R.id.x0y1, new Point(0, 1));
        buttonCoordinates.put(R.id.x1y1, new Point(1, 1));
        buttonCoordinates.put(R.id.x2y1, new Point(2, 1));
        buttonCoordinates.put(R.id.x0y2, new Point(0, 2));
        buttonCoordinates.put(R.id.x1y2, new Point(1, 2));
        buttonCoordinates.put(R.id.x2y2, new Point(2, 2));
        buttons.put(R.id.x0y0, view.findViewById(R.id.x0y0));
        buttons.put(R.id.x1y0, view.findViewById(R.id.x1y0));
        buttons.put(R.id.x2y0, view.findViewById(R.id.x2y0));
        buttons.put(R.id.x0y1, view.findViewById(R.id.x0y1));
        buttons.put(R.id.x1y1, view.findViewById(R.id.x1y1));
        buttons.put(R.id.x2y1, view.findViewById(R.id.x2y1));
        buttons.put(R.id.x0y2, view.findViewById(R.id.x0y2));
        buttons.put(R.id.x1y2, view.findViewById(R.id.x1y2));
        buttons.put(R.id.x2y2, view.findViewById(R.id.x2y2));
        for (int id : buttons.keySet()) {
            buttons.get(id).setOnClickListener(this::onClick);
        }
    }



    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    public void turn(IPoint point) {
        IPlayer currentPlayer = players.get(whichPlayer);
        field.setFigure(currentPlayer.getFigure(), point);
        if (moveController.hasEmptyCell()) {
            if (winnerController.getWinner() != null) {
                showWinner(players.get(whichPlayer));
                refresh();
                init();
                return;
            }
            nextPlayer();
            if (players.get(whichPlayer).isCpu()) {
                IPoint result = new Point(-1, -1);
                while (!moveController.validateCoordinates(result)) {
                    result = cpuPlayerLogic.getCpuPoint(field);
                }
                turn(result);
            }
        }
        if (!moveController.hasEmptyCell()) {
            refresh();
            Toast.makeText(getContext(),
                    String.format("Sorry, the field is full. No winner...%nGame Over."),
                    Toast.LENGTH_LONG)
                    .show();
            init();
            return;
        }
        refresh();
    }

    private void nextPlayer() {
        whichPlayer++;
        if (whichPlayer >= players.size()) {
            whichPlayer = 0;
        }
    }

    private void refresh() {
        for (Map.Entry<Integer, IPoint> buttonCoordinate : buttonCoordinates.entrySet()) {
            int id = buttonCoordinate.getKey();
            if (field.getFigure(buttonCoordinate.getValue()) != null) {
                buttons.get(id).setText(field.getFigure(buttonCoordinate.getValue()).getImage().toString());
            } else {
                buttons.get(id).setText("");
            }
        }
        whoseTurnTextView.setText(String.format("%s  %s", getString(R.string.next_turn), players.get(whichPlayer).getName()));
    }

    private void showWinner(IPlayer player) {
        Toast.makeText(getContext(),
                String.format("Winner is the %s, his figure %s. %nCongratulations!!!",
                        player.getName(), player.getFigure().getImage()),
                Toast.LENGTH_LONG)
                .show();
    }

    public void onClick(View view) {
        int id = view.getId();
        IPoint p = buttonCoordinates.get(id);
        if (moveController.validateCoordinates(p)) {
            turn(p);
        } else {
            Toast.makeText(getContext(),
                    "Wrong turn, please select another cell",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void onSwitchOn(View view) {
        if (cpuSwitch.isChecked()) {
            players.get(1).setCpu(true);
        } else {
            players.get(1).setCpu(false);
        }
    }
}
