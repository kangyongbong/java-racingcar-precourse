package racinggame.controller;

import racinggame.domain.RacingGameService;

public class RacingGameController {
    public void start() {
        RacingGameService racingGameService = new RacingGameService();
        racingGameService.startGame();
    }
}
