package racingcar.view;

import racingcar.constant.GameMessage;
import racingcar.model.vo.Car;

public class OutputView {

    public void outputResult() {
        System.out.print(GameMessage.OUTPUT_RESULT.getMessage());
    }

    public void outputResultCar(Car car) {
        System.out.printf(
                GameMessage.OUTPUT_RESULT_CAR
                        .getMessage()
                ,car.getCarName()
                        .getName()
                ,car.getCarPosition()
                        .isPosition()
        );
    }

    public void outputEndGame(String winner) {
        System.out.printf(
                GameMessage.OUTPUT_WINNER
                        .getMessage()
                , winner
        );
    }
}
