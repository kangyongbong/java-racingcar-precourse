package racinggame.domain;

import racinggame.constant.ErrorMessageConstant;

public class Car {
    private String carName;
    private int position;

    public Car() {
        this.position = 0;
    }

    public Car(String carName) {
        validateEmptyName(carName);
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private void validateEmptyName(String carName) {
        if (carName == null || carName.replaceAll(" ", "").equals("")) {
            throw new IllegalArgumentException(ErrorMessageConstant.ERR_MSG_EMPTY);
        }
    }
}
