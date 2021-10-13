package racinggame.service.impl;

import racinggame.constant.ErrorMessageConstant;
import racinggame.constant.GameMessageConstant;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.RandomNum;
import racinggame.service.RacingGameService;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.NoSuchElementException;

public class RacingGameServiceImpl implements RacingGameService {

    private Cars cars;
    private InputView inputView;
    private OutputView outputView;

    public RacingGameServiceImpl() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    @Override
    public String startGame() {
        inputCarNames();
        int loopCount = inputLoopCount();
        for (int i = 0; i < loopCount; i++) {
            racingLoop();
        }

        return validateWinner(loopCount);
    }

    @Override
    public void inputCarNames() {
        String carName = inputView.inputCarName();
        cars = new Cars(carName);
    }

    @Override
    public int inputLoopCount() {
        String loopCount = inputView.inputRacingLoop();
        if (loopCount == null) {
            throw new IllegalArgumentException(ErrorMessageConstant.ERR_MSG_LOOP);
        }
        return  Integer.parseInt(loopCount);
    }

    @Override
    public void racingLoop() {
        for (int i = 0; i < cars.getCarsSize(); i++) {
            cars.moveForword(i, new RandomNum());
            resultMsg(cars.getCar(i));
        }
    }

    @Override
    public void resultMsg(Car car) {
        StringBuilder positionLine = new StringBuilder();
        for (int i = 0; i < car.getPosition().getCarPosition(); i++) {
            positionLine.append(GameMessageConstant.CAR_LINE_MSG);
        }
        outputView.outputResult(car.getCarName(), positionLine.toString());
    }

    @Override
    public String validateWinner(int loopCount) {
        String winnerNames = "";
        for (int i = 0; i < cars.getCarsSize(); i++) {
            Car car = cars.getCar(i);
            validateLoop(car, loopCount);
            winnerNames = makeWinnerNames(car, winnerNames);
        }

        return winnerNames;
    }

    @Override
    public void validateLoop(Car car, int loopCount) {
        if(car.getPosition().getGameIndex() != loopCount){
            throw new IllegalArgumentException(ErrorMessageConstant.ERR_MSG_LOOP);
        }
    }

    @Override
    public String makeWinnerNames(Car car, String winnerNames) {
        int max = cars.maxPosition();
        if(max > 0 && car.getCarPosition() == max){
            return appendNames(car, winnerNames);
        }

        return winnerNames;
    }

    @Override
    public String appendNames(Car car, String winnerNames) {
        if (winnerNames != null && !winnerNames.equals("")) {
            winnerNames = winnerNames + ",";
        }

        return winnerNames + car.getCarName();
    }
}
