package racinggame.domain;

import racinggame.constant.ErrorMessageConstant;
import racinggame.constant.MoveForwordConstant;

public class Car {
    private final String carName;
    private final Position position;

    public Car(String carName) {
        validateEmptyName(carName);
        this.carName = carName;
        this.position = new Position(MoveForwordConstant.START_POSITION);
    }

    private void validateEmptyName(String carName) {
        if (carName == null || carName.replaceAll(" ", "").equals("")) {
            throw new IllegalArgumentException(ErrorMessageConstant.ERR_MSG_EMPTY);
        }
    }

    public String getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }
}
