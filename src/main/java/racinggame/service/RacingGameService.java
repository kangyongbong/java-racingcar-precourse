package racinggame.service;

import racinggame.domain.Car;

public interface RacingGameService {

    String startGame();

    void inputCarNames();

    int inputLoopCount();

    void racingLoop();

    void resultMsg(Car car);

    void validateLoop(Car car, int loopCount);

    String validateWinner(int loopCount);

    String makeWinnerNames(Car car, String winnerNames);

    String appendNames(Car car, String winnerNames);
}
