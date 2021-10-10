package racinggame.controller;

import racinggame.service.RacingGameService;
import racinggame.service.impl.RacingGameServiceImpl;

public class RacingGameController {
    public void start() {
        RacingGameService racingGameService = new RacingGameServiceImpl();
        racingGameService.startGame();
    }
}
