package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.constant.InputDefinitionConstant;

public class RandomNum {
    private final int randomNum;

    public RandomNum() {
        this.randomNum = createRandomNumber();
    }

    public int getRandomNum() {
        return randomNum;
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(InputDefinitionConstant.NUM_MIN, InputDefinitionConstant.NUM_MAX);
    }
}
