package racinggame.controller;

import racinggame.service.RacingGameService;
import racinggame.service.impl.RacingGameServiceImpl;
import racinggame.view.OutputView;

import java.util.NoSuchElementException;

public class RacingGameController {

    private RacingGameService racingGameService;
    private OutputView outputView;

    public RacingGameController() {
        this.racingGameService = new RacingGameServiceImpl();
        this.outputView = new OutputView();
    }

    public void start() {
        try {
            String winner = racingGameService.startGame();
            outputView.outputEndGame(winner);
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }
}
