package racinggame.domain;

import racinggame.constant.MoveForwordConstant;

public class Position {
    private int carPosition;
    private int gameIndex;
    private int lastNumber;

    public Position(int carPosition) {
        this.gameIndex = 0;
        this.lastNumber = 0;
        this.carPosition = carPosition;
    }

    public void moveForwod(RandomNum randomNum) {
        this.gameIndex++;
        this.lastNumber = randomNum.getRandomNum();
        validateMove(randomNum);
    }

    private void validateMove(RandomNum randomNum) {
        if (randomNum.getRandomNum() >= MoveForwordConstant.FORWORD_NUMBER) {
            this.carPosition++;
        }
    }

    public int getCarPosition() {
        return carPosition;
    }

    public int getGameIndex() {
        return gameIndex;
    }

    public int getLastNumber() {
        return lastNumber;
    }
}
