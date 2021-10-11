package racinggame.view;

import nextstep.utils.Console;
import racinggame.constant.GameMessageConstant;

public class InputView {

    public String inputCarName() {
        System.out.println(GameMessageConstant.INPUT_NAME_MSG);
        return Console.readLine();
    }

    public String inputRacingLoop() {
        System.out.println(GameMessageConstant.INPUT_LOOP_MSG);
        return Console.readLine();
    }
}
