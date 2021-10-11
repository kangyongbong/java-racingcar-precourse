package racinggame.view;

import nextstep.utils.Console;
import racinggame.constant.GameMessageConstant;

public class OutputView {

    public void outputResult(String carName, String statusLine) {
        System.out.printf(GameMessageConstant.OUPUT_RACING_MSG, carName, statusLine);
    }

    public void outputEndGame(String winner) {
        System.out.printf(GameMessageConstant.OUTPUT_END_MSG, winner);
    }
}
